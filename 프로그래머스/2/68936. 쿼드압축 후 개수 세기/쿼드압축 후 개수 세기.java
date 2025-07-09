import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        int zero_total = 0;
        int one_total = 0;
        int n = arr.length;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, n}); // x, y, size

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int size = cur[2];

            if (isAllSame(arr, x, y, size)) {
                if (arr[x][y] == 0) zero_total++;
                else one_total++;
            } else {
                int half = size / 2;
                q.add(new int[]{x, y, half});                     // 1사분면
                q.add(new int[]{x, y + half, half});              // 2사분면
                q.add(new int[]{x + half, y, half});              // 3사분면
                q.add(new int[]{x + half, y + half, half});       // 4사분면
            }
        }

        return new int[]{zero_total, one_total};
    }

    private boolean isAllSame(int[][] arr, int x, int y, int size) {
        int base = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != base) return false;
            }
        }
        return true;
    }
}
