import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int idx = 0;
        int last = discount.length - 10;
        while (idx <= last){
            Map<String,Integer> map = new HashMap<>();
            for(int i = 0; i<want.length; i++){
                String fruit = want[i];
                int count = number[i];
                map.put(fruit,count);
            }
            
            for(int i = idx; i<idx+10; i++){
                String food = discount[i];
                if(map.containsKey(food)){
                    map.put(food,map.get(food)-1);
                }
            }
            boolean check = true;
            for(Integer s: map.values()){
                if(s!=0){
                    check = false;
                    break;
                }
            }
            if(check){
                answer++;
            }
            idx++;
        }
        
        return answer;
    }
}