import java.util.*;
class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        String num = String.valueOf(n);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < num.length(); i++){
            list.add(Integer.parseInt(String.valueOf(num.charAt(i))));
        }
        Collections.sort(list,Collections.reverseOrder());
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
        }
        return Long.parseLong(sb.toString());
    }
}