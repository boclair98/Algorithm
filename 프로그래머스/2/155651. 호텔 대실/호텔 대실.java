import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time,(a,b) -> a[0].compareTo(b[0]));
        //시간 저장
        List<Integer> time = new ArrayList<>();
        
       
        for(int i = 0; i<book_time.length; i++){
            String[] num = book_time[i];
            int start = time_change(num[0]);
            int finish = time_change(num[1])+10;
            
            boolean check = false;
            for(int j = 0; j<time.size(); j++){
                if(start >= time.get(j)){
                    time.set(j,finish);
                    check = true;
                    break;
                }
            }
                
            if(!check){
                time.add(finish);
            }
        }
        
        
        return time.size();
    }
    
    public static int time_change(String t){
        String[] num = t.split(":");
        return Integer.parseInt(num[0]) * 60 + Integer.parseInt(num[1]);
    }
}