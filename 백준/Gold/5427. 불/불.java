import java.io.*;
import java.util.*;

public class Main {
    static int t, n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dist, dist1;
    static char[][] map;
    static Queue<int[]> fire, human;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            map = new char[n][m];
            dist = new int[n][m];
            dist1 = new int[n][m];
            fire = new LinkedList<>();
            human = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                String row = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = row.charAt(j);
                    dist[i][j] = -1;
                    dist1[i][j] = -1;
                    if (map[i][j] == '*') {
                        fire.offer(new int[]{i, j});
                        dist[i][j] = 0;
                    }
                    if (map[i][j] == '@') {
                        human.offer(new int[]{i, j});
                        dist1[i][j] = 0;
                    }
                }
            }

            // 불 BFS
            while (!fire.isEmpty()) {
                int[] cur = fire.poll();
                int x = cur[0], y = cur[1];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d], ny = y + dy[d];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (map[nx][ny] == '#' || dist[nx][ny] != -1) continue;
                    dist[nx][ny] = dist[x][y] + 1;
                    fire.offer(new int[]{nx, ny});
                }
            }

            // 사람 BFS
            boolean escaped = false;
            while (!human.isEmpty()) {
                int[] cur = human.poll();
                int x = cur[0], y = cur[1];

                // 탈출 조건: 가장자리 도달
                if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
                    System.out.println(dist1[x][y] + 1);
                    escaped = true;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d], ny = y + dy[d];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (map[nx][ny] == '#' || dist1[nx][ny] != -1) continue;
                    // 불보다 빨리 도착할 수 있어야 함
                    if (dist[nx][ny] != -1 && dist[nx][ny] <= dist1[x][y] + 1) continue;
                    dist1[nx][ny] = dist1[x][y] + 1;
                    human.offer(new int[]{nx, ny});
                }
            }

            if (!escaped) System.out.println("IMPOSSIBLE");
        }
    }
}
