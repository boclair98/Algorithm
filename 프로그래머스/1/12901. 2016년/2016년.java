import java.util.*;
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int m = 1;
        int d = 1;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        String[] days = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        for(int i=1; i<=12; i++){
            if(i == 2){
                map.put(i,29);
            }else if(i==1 || i==3 || i ==5 || i == 7 || i == 8 || i == 10 || i == 12){
                map.put(i,31);
            }else{
                map.put(i,30);
            }
        }
        // System.out.println(map);
        while (true){
            if(m == a && d == b){
                break;
            }
            d++;
            count++;
            if(map.get(m)<d){
                m++;
                d = 1;
                
            }
        }
        // System.out.println(d+" "+m+" "+count);
        answer = days[count%7];
        return answer;
    }
}