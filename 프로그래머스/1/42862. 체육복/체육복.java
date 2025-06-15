import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int count = 0 ;
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i = 0; i<reserve.length; i++){
            int num = reserve[i];
            // System.out.println(num);
            if(map.get(num) == null){
                map.put(num,1);
            }
        }
        for(int i = 0; i<lost.length; i++){
            int number = lost[i];
            for(Integer s : map.keySet()){
                if(number == s){
                    if(map.get(s) == 1){
                        map.put(s,0);
                    }
                }
            }
        }
       
        
        for(int i = 0; i<lost.length; i++){
            int number = lost[i];
            for(Integer s : map.keySet()){
                // System.out.println(map);
                if(s == number){
                    break;
                }
                if(s - 1  == number && map.get(s-1) == null){
                    if(map.get(s)==1){
                        map.put(s,map.get(s)-1);
                        break;
                    }  
                }
                if(s + 1 == number && map.get(s+1) == null){
                    if(map.get(s) == 1){
                        map.put(s,map.get(s)-1);
                        break;
                    }
                }
            }
            
        }
        // System.out.println(map);
        for(Integer num: map.keySet()){
            if(map.get(num) == 0){
                count++;
            }
        }
        // System.out.println(count);
        if(lost.length <=count){
            answer = 0;
        }else{
            answer = lost.length -count ;
        }
        return n-answer;
    }
}
    