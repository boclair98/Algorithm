import java.util.*;
import java.lang.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int count = 0 ;
        startday -=1;
        //요일 설정 
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<=7; i++){
            list.add(i);
        }
    
        
        //로직
        int n = schedules.length;
        int m = timelogs.length;
        for(int i = 0; i<n; i++){
            int time = schedules[i] + 10;
            int day = startday;
            if(time % 100 >= 60){
                time+=100;
                time-=60;
            }
            count = 0 ; 
            for(int j = 0; j<7; j++){
                if(list.get(day) == 6 || list.get(day) == 7){
                    count++;
                }else{
                    if(time>=timelogs[i][j]){
                        count++;
                    }
                }
                day = (day+1) % 7;
                
            }
            if(count == 7){
                answer++;
            }
        }
        return answer;
    }
}