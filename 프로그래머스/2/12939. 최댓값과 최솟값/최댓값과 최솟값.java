import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] ans = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < ans.length; i++){
            list.add(Integer.parseInt(ans[i]));
        }
        Collections.sort(list);
        answer.append(list.get(0)).append(" ").append(list.get(list.size()-1));
        return answer.toString();
    }
}