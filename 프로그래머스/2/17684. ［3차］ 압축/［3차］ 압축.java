import java.util.*;
class Solution {
    public List<Integer> solution(String msg) {
        StringBuilder sb = new StringBuilder();;
        List<Integer> answer = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        List<String> w = new ArrayList<>();
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 1; i <= s.length(); i++){
            map.put(String.valueOf(s.charAt(i-1)),i);
        }
        
        int number = 27;
        int start_idx = 0;
        int idx = 0;
        while(start_idx < msg.length()){
            sb.append(msg.charAt(start_idx));
            if(map.containsKey(sb.toString())){
                start_idx++;
            }else{
                map.put(sb.toString(), number++);
                answer.add(map.get(sb.toString().substring(0,sb.toString().length()-1)));
                sb = new StringBuilder();              
            }
        }
        answer.add(map.get(sb.toString()));
        
        return answer;
    }
}