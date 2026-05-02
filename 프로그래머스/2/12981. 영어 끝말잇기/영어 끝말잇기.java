import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int num = 1;
        int cnt = 0;
        Set<String> set = new HashSet<>();
        int idx = 0;
        boolean flag = false;
        while(idx < words.length){
            if(cnt > n) {
                cnt = 1;
                num++;
            }
            if(idx == 0){
                set.add(words[idx]);
                cnt++;
            }else{
                char end = words[idx-1].charAt(words[idx-1].length()-1);
                char start = words[idx].charAt(0);
                if(end != start){
                    flag = true;
                    break;
                }
                if(set.contains(words[idx])){
                    flag = true;
                    break;
                }
                set.add(words[idx]);
            }
            cnt++;
            idx++;
        }
        if(!flag){
            return answer;
        }
        answer[0] = cnt;
        answer[1] = num;
        return answer;
    }
}