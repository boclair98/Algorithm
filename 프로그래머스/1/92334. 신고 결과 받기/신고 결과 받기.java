import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> map1 =  new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<id_list.length; i++){
            map.put(id_list[i], new HashSet<String>());
        }
        for(int i = 0; i<report.length; i++){
            String[] name = report[i].split(" ");
            map.get(name[1]).add(name[0]);
        }
        for(int i = 0; i<id_list.length; i++){
            String word = id_list[i];
            if(map.get(word).size()>=k){
                for(String names : map.get(word)){
                    if(map1.get(names) == null){
                        map1.put(names,1);
                    }else{
                        map1.put(names,map1.get(names)+1);
                    }
                }
            }
        }
        // System.out.println(map1);
        for(int i = 0; i<id_list.length; i++){
            if(map1.get(id_list[i]) == null){
                answer[i] = 0;
                continue;
            }
            answer[i] = map1.get(id_list[i]);
        }
        return answer;
    }
}