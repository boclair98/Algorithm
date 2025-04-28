import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static Character[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited, visited1;
    static StringTokenizer st;
    static int[][] dist2, dist1;
    static Queue<int[]> fire, ji;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new Character[n][m];
        dist1 = new int[n][m];
        dist2 = new int[n][m];
        visited = new boolean[n][m];
        visited1 = new boolean[n][m];
        fire = new LinkedList<>();
        ji = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = word.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist1[i], -1);
            Arrays.fill(dist2[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'J') {
                    ji.offer(new int[]{i, j});
                    dist1[i][j] = 1;
                }
                if (map[i][j] == 'F') {
                    fire.offer(new int[]{i, j});
                    dist2[i][j] = 1;
                }
            }
        }

        while (!fire.isEmpty()) {
            int[] cur = fire.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (map[nx][ny] == '.' && dist2[nx][ny] == -1) {
                    dist2[nx][ny] = dist2[x][y] + 1;
                    fire.offer(new int[]{nx, ny});
                }
            }
        }

        while (!ji.isEmpty()) {
            int[] cur = ji.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    System.out.println(dist1[x][y]);
                    return;
                }
                if (dist1[nx][ny] != -1 || map[nx][ny] == '#') continue;
                if (dist2[nx][ny] != -1 && dist2[nx][ny] <= dist1[x][y] + 1) continue;
                dist1[nx][ny] = dist1[x][y] + 1;
                ji.offer(new int[]{nx, ny});
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
