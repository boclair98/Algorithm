import java.util.*;
class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        
        String w = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i<w.length(); i++){
            String w1 = w.charAt(i)+"";
            map.put(w1,i+1);
        }
        int number = 27;
        int idx = 0;
        String word = "";
        while (idx < msg.length()){
            word+=msg.charAt(idx)+"";
            if(map.containsKey(word)){
                idx++;
            }else{
                answer.add(map.get(word.substring(0,word.length()-1)));
                map.put(word,number++);
                word="";
            }
        }
        answer.add(map.get(word));
        return answer;
    }
}