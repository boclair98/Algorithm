import java.util.*;

class Solution {
    public List<Integer> solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        int[][] map = new int[rows][columns];
        int count = 1;

        // 1부터 차례대로 초기화
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = count++;
            }
        }

        for (int[] query : queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;

            int temp = map[x1][y1]; // 시작점 값 보관
            int min = temp;

            // 1. 왼쪽 (위 → 아래)
            for (int x = x1; x < x2; x++) {
                map[x][y1] = map[x + 1][y1];
                min = Math.min(min, map[x][y1]);
            }

            // 2. 아래쪽 (왼 → 오)
            for (int y = y1; y < y2; y++) {
                map[x2][y] = map[x2][y + 1];
                min = Math.min(min, map[x2][y]);
            }

            // 3. 오른쪽 (아래 → 위)
            for (int x = x2; x > x1; x--) {
                map[x][y2] = map[x - 1][y2];
                min = Math.min(min, map[x][y2]);
            }

            // 4. 위쪽 (오 → 왼)
            for (int y = y2; y > y1 + 1; y--) {
                map[x1][y] = map[x1][y - 1];
                min = Math.min(min, map[x1][y]);
            }

            map[x1][y1 + 1] = temp; // 저장해둔 값 복구
            answer.add(min);
        }

        return answer;
    }
}
