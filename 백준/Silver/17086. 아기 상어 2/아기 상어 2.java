import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n,m;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static Deque<int[]> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        dist = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;
                if(map[i][j] == 1){
                    dq.add(new int[]{i,j});
                    dist[i][j] = 0;
                }
            }
        }
        int max_distance = 0;
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i < 8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(dist[nx][ny] == -1){
                    dist[nx][ny] = dist[x][y] + 1;
                    max_distance = Math.max(max_distance,dist[nx][ny]);
                    dq.add(new int[]{nx,ny});
                }
            }
        }
        System.out.println(max_distance);
    }
}