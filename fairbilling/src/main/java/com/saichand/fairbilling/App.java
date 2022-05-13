package com.saichand.fairbilling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class App 
{
	public static final String START_MODE = "Start";
	public static final String END_MODE = "End";
	public static String total_lines;
    public static void main( String[] args )
    {
        try {
			
			  if(args.length<1) { 
				  System.out.println("No arguments"); 
			}
			 
			 
        	String fileName = args[args.length-1];
        	//String fileName = "res/log.txt";
        	FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();
			while((total_lines = br.readLine())!=null) {
				sb.append(total_lines);
				sb.append("\n");
			}
			total_lines = sb.toString();
			String[] stringarray = total_lines.split("\n");
			List<EachLine> lns =new ArrayList<>(); 
			for(int i=0;i<stringarray.length;i++) {
				String [] stringsplit = stringarray[i].split(" ");
				EachLine lines = new EachLine(stringsplit[0],stringsplit[1],stringsplit[2]);
				lns.add(lines);
			}
			String firstTime = lns.get(0).getTime();
			String lastTime = lns.get(lns.size()-1).getTime();
			
			Map<String, List<UserTimes>> map = processTheLines(lns);
			
			List<Result> results=new ArrayList<>();
			for(String userName:map.keySet()) {
				long total =0;
				int sessions =0;
				for(UserTimes users:map.get(userName)) {
					sessions++;
					if(users.getStartTime()==null) {
						users.setStartTime(firstTime);
					}
					if(users.getEndTime()==null) {
						users.setEndTime(lastTime);
					}
					SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
					Date date1 = (Date) format.parse(users.getStartTime()); 
					Date date2 = (Date) format.parse(users.getEndTime());
					long diff = date2.getTime() - date1.getTime();
					long diff_secs = TimeUnit.MILLISECONDS.toSeconds(diff);
					total = total+diff_secs;
				}
				results.add(new Result(userName,sessions,total));
			}
			
			//output
			for(Result output:results) {
				System.out.println(output.getUserName()+" "+output.getTotalSessions()+" "+output.getTotalSeconds());
			}
			
        	
        }catch(Exception exception) {
        	System.out.println("Exception:"+exception);
        }
    }
	private static Map<String, List<UserTimes>> processTheLines(List<EachLine> lns) {
		
		Map<String, List<UserTimes>> sessionMap = new LinkedHashMap<>();
		for(EachLine lines:lns) {
			List<UserTimes> sessionList = sessionMap.get(lines.getUserName());
			sessionList=processEachLine(lines,sessionList);
			sessionMap.put(lines.getUserName(), sessionList);
		}
		return sessionMap;
	}
	private static List<UserTimes> processEachLine(EachLine lines, List<UserTimes> sessionList) {
		if(sessionList==null) {
			sessionList = new ArrayList<UserTimes>();
		}
		String time = lines.getTime();
		if(START_MODE.equals(lines.getMode())) {
			UserTimes userSession = new UserTimes(lines.getUserName());
			userSession.setStartTime(time);
			sessionList.add(userSession);
			return sessionList;
		}
		for(UserTimes userSession :sessionList ) {
			if(userSession.getEndTime()==null) {
				userSession.setEndTime(time);
				return sessionList;
			}
		}
		UserTimes userSession =new UserTimes(lines.getUserName());
		userSession.setEndTime(time);
		sessionList.add(userSession);
		return sessionList;
	}
}
