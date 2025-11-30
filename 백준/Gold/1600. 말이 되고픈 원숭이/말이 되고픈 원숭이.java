import java.io.*;
import java.util.*;

public class Main {
    static int k, n, m;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};

    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][k+1];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());

    }

    private static int bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0,0,k,0});
        visited[0][0][k] = true;
        while(!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            int k = cur[2];
            int count = cur[3];
            if(x == n-1 && y == m-1) {
                return count;
            }
            for(int i = 0 ; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx>=n || ny < 0 || ny>=m) continue;
                if(map[nx][ny] == 0 &&!visited[nx][ny][k]){
                    visited[nx][ny][k] = true;
                    dq.add(new int[]{nx,ny,k,count+1});
                }
            }
            if(k > 0){
                for(int i = 0; i<8; i++){
                    int nx = x + hx[i];
                    int ny = y + hy[i];
                    if(nx < 0 || nx>=n || ny < 0 || ny>=m) continue;
                    if(map[nx][ny] == 0 && !visited[nx][ny][k-1]){
                        visited[nx][ny][k-1] = true;
                        dq.add(new int[]{nx,ny,k-1,count+1});
                    }

                }
            }
        }
        return -1;
    }
}

