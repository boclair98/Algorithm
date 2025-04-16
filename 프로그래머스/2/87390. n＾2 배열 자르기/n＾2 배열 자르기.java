import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) right - (int) left + 1;
        int[] answer = new int[len];
        int idx = 0;
        for(long i =left; i<=right; i++){
            answer[idx] = (int)Math.max(i/n,i%n)+1;
            idx++;
        }
        return answer;
    }
}