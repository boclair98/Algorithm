import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int startX, startY;
    static int SHARK_LEVEL = 2;
    static int[][] map;
    static int count_shark = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int time = 0;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    startX = i;
                    startY = j;
                    map[i][j] = 0;
                }
            }
        }
        while (true) {
            checkShark(startX, startY);
            if(list.isEmpty()) break;
            Collections.sort(list, (a, b) -> {
                if(a[2]!=b[2]) return a[2] - b[2];
                else if(a[0]!=b[0]) return a[0] -b[0];
                return a[1] - b[1];
            });
            time += list.get(0)[2];
            startX = list.get(0)[0];
            startY = list.get(0)[1];
            map[startX][startY] = 0;
            count_shark++;
            if (count_shark == SHARK_LEVEL) {
                count_shark = 0;
                SHARK_LEVEL++;
            }
        }
        System.out.println(time);
    }

    public static void checkShark(int sx, int sy){
        Queue<int[]> q = new ArrayDeque<>();
        list.clear();
        boolean[][] visited = new boolean[n][n];
        q.offer(new int[]{sx,sy,0});
        visited[sx][sy] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                if(map[nx][ny] <= SHARK_LEVEL && !visited[nx][ny]){
                    q.offer(new int[]{nx,ny,dist+1});
                    visited[nx][ny] = true;
                }
                if(map[nx][ny] < SHARK_LEVEL && map[nx][ny] > 0){
                    list.add(new int[]{nx,ny,dist+1});
                }
            }
        }

    }
}
