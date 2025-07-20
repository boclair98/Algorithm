import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        int cnt = 1;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] = cnt++;

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(matrix, queries[i]);
        }
        return answer;
    }

    // 시계 방향으로 1칸 회전시키고, 이동된 숫자 중 최솟값을 반환
    private int rotate(int[][] m, int[] q) {
        int x1 = q[0] - 1, y1 = q[1] - 1;
        int x2 = q[2] - 1, y2 = q[3] - 1;

        int prev = m[x1][y1];
        int min = prev;

        // → 방향 (윗변)
        for (int j = y1 + 1; j <= y2; j++) {
            int tmp = m[x1][j];
            m[x1][j] = prev;
            prev = tmp;
            min = Math.min(min, prev);
        }
        // ↓ 방향 (오른쪽변)
        for (int i = x1 + 1; i <= x2; i++) {
            int tmp = m[i][y2];
            m[i][y2] = prev;
            prev = tmp;
            min = Math.min(min, prev);
        }
        // ← 방향 (아랫변)
        for (int j = y2 - 1; j >= y1; j--) {
            int tmp = m[x2][j];
            m[x2][j] = prev;
            prev = tmp;
            min = Math.min(min, prev);
        }
        // ↑ 방향 (왼쪽변)
        for (int i = x2 - 1; i >= x1; i--) {
            int tmp = m[i][y1];
            m[i][y1] = prev;
            prev = tmp;
            min = Math.min(min, prev);
        }

        return min;
    }
}
