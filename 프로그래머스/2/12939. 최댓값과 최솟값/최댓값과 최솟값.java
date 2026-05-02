import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] num = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < num.length; i++){
            list.add(Integer.parseInt(num[i]));
        }
        Collections.sort(list);
        answer.append(list.get(0)).append(" ").append(list.get(list.size()-1));
        return answer.toString();
    }
}