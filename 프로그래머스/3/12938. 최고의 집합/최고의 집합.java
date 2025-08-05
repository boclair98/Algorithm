import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }

        int[] answer = new int[n];
        int div = s / n;
        int remain = s % n;

        // 모든 값에 몫 채우기
        Arrays.fill(answer, div);

        // 뒤에서부터 1씩 나머지 분배
        for (int i = n - 1; i >= n - remain; i--) {
            answer[i]++;
        }

        return answer;
    }
}
