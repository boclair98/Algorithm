import java.util.*;
import java.lang.*;
class Solution {
    public List<Integer> solution(int[] lottos, int[] win_nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =1; i<=6; i++){
            map.put(i,6-i+1);
        }
        
        int count = 0;
        int zero_count =0 ;
        int n = lottos.length;
        for(int i = 0; i<n; i++){
            if (lottos[i] == 0){
                zero_count ++;
            }
            for(int j = 0; j<n; j++){
                if(lottos[i]!=0){
                    if(lottos[i] == win_nums[j]){
                        count++;
                    }
                }
            }
        }
        if(count == 0 && zero_count == 0){
            list.add(6);
            list.add(6);
        }else if(zero_count == 6){
            list.add(1);
            list.add(6);
        } else if(count == 6){
            list.add(1);
            list.add(1);
        } else{
            if(map.containsValue(count+zero_count)){
                for(Integer num: map.keySet()){
                    if(map.get(num) == count+zero_count){
                        list.add(num);
                    }
                }

            }
            if(map.containsValue(count)){
                for(Integer num: map.keySet()){
                    if(map.get(num) == count){
                        list.add(num);
                    }
                }
            
            } 
        }
        return list;
    }
}