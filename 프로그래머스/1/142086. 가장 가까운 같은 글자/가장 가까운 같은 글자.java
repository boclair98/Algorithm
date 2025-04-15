import java.util.*;
class Solution {
    public List<Integer> solution(String s) {
        List<Integer> list = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        for(int i = 0; i<n; i++){
            char word = s.charAt(i);
            if (map.containsKey(word)){
                list.add(i-map.get(word));
                map.replace(word,i);
            }else{
                list.add(-1);
                map.put(word,i);
            }
        }
        return list;
    }
}