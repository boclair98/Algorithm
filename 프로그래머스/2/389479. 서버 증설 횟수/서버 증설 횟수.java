import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> time = new ArrayDeque<>();

        for (int i = 0; i < players.length; i++) {
            // 1. 만료된 서버 제거
            while (!time.isEmpty() && time.peek() <= i) {
                time.poll();
            }

            // 2. 필요한 서버 수 계산 (올림 처리)
            int need = (players[i] ) / m;

            // 3. 현재 가동 서버 수
            int current = time.size();

            // 4. 부족한 서버 개수만큼 추가
            int toAdd = need - current;
            for (int j = 0; j < toAdd; j++) {
                time.offer(i + k);
                answer++;
            }

            // 디버그 출력 (필요 시)
            System.out.println("time: " + time + ", answer: " + answer);
        }

        return answer;
    }
}
