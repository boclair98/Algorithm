import java.util.*;
class Solution{
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i<participant.length; i++){
            String word = participant[i];
            if(map.get(word) == null){
                map.put(word,1);
            }else{
                map.put(word,map.get(word)+1);
            }
        }
        for(int i = 0; i<completion.length; i++){
            String word = completion[i];
            if(map.get(word) > 0){
                map.put(word,map.get(word)-1);
            }
        }
        
        for(String name: map.keySet()){
            if(map.get(name)>0){
                answer = name;
                break;
            }
        }
        return answer;
    }
}