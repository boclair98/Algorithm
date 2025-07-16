import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int n = musicinfos.length;
        m = changeName(m);
        List<String[]> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            String[] information = musicinfos[i].split(",");
            String start = information[0];
            String end = information[1];
            String name = information[2];
            String music = information[3];
            music = changeName(music);
            
            int time = time(start,end);
            if(time > music.length()){
                music = song(music,time);
            }else{
                music = music.substring(0,time);
            }
            
            if(check(m,music)&& time>=m.length()){
                list.add(new String[]{start,String.valueOf(time),name});
            }
            
        }
        if(list.size() == 0){
            return "(None)";
        }
        list.sort((a, b) -> {
                int timeCompare = Integer.parseInt(b[1]) - Integer.parseInt(a[1]);
                if (timeCompare != 0) return timeCompare;
                return a[0].compareTo(b[0]);
        });
        answer = list.get(0)[2];
        return answer;
    }
    
    
    //시간 계산 함수.
    private static int time(String start, String end){
        String[] start_time = start.split(":");
        String[] end_time = end.split(":");
        
        int starts = Integer.parseInt(start_time[0]) * 60 + Integer.parseInt(start_time[1]);
        int ends = Integer.parseInt(end_time[0]) * 60 + Integer.parseInt(end_time[1]);
        
        return ends - starts;
        
    }
    
    private static String song(String music, int time){
        StringBuilder sb = new StringBuilder(music);
        int idx = 0;
        int setting = music.length();
        while(sb.length() < time){
            sb.append(music.charAt(idx));
            idx = (idx + 1) % setting;
        }
        return sb.toString();
    }
    
    private static String changeName(String m){
        
        return m.replace("C#","c")
                .replace("D#","d")
                .replace("F#","f")
                .replace("G#","g")
                .replace("A#","a")
                .replace("B#","b");
    }
    
    private static boolean check(String name, String music){
        return music.contains(name);
    }
}