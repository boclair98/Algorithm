import java.util.*;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int max_cnt = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            if(map.get(array[i]) == null){
                map.put(array[i],1);
            }else{
                map.put(array[i],map.get(array[i])+1);
            }
            max_cnt = Math.max(max_cnt,map.get(array[i]));
        }
        List<Integer> list = new ArrayList<>();
        for(Integer s : map.keySet()){
            if(map.get(s) == max_cnt){
                list.add(s);
            }
        }
        if(list.size() > 1){
            return -1;
        }
        
        return list.get(0);
    }
}