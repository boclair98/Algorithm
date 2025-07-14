import java.util.*;

class Solution {
    static int n, m;
    static int[] dx = {1, 0, -1, 0}; // 하 우 상 좌
    static int[] dy = {0, 1, 0, -1};
    static String[][] maps;
    static boolean[][] visited;

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        maps = new String[n][m];
        visited = new boolean[n][m];
        int sx = 0, sy = 0;
        int gx = 0, gy = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maps[i][j] = board[i].charAt(j) + "";
                if (maps[i][j].equals("R")) {
                    sx = i;
                    sy = j;
                }
                if (maps[i][j].equals("G")) {
                    gx = i;
                    gy = j;
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int count = now[2];

            if (x == gx && y == gy) {
                return count;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x;
                int ny = y;

                // 미끄러지기
                while (true) {
                    int tx = nx + dx[dir];
                    int ty = ny + dy[dir];

                    if (tx < 0 || ty < 0 || tx >= n || ty >= m) break;
                    if (maps[tx][ty].equals("D")) break;

                    nx = tx;
                    ny = ty;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, count + 1});
                }
            }
        }

        return -1; // 도달 못한 경우
    }
}
