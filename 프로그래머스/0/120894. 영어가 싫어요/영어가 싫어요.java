import java.util.*;
class Solution {
    public long solution(String numbers) {
        long answer = 0;
        StringBuilder num = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while(idx < numbers.length()){
            sb.append(numbers.charAt(idx));
            if(map.containsKey(sb.toString())){
                num.append(map.get(sb.toString()));
                sb = new StringBuilder();
            }
            idx++;
        }
        answer = Long.parseLong(num.toString());
        return answer;
    }
}