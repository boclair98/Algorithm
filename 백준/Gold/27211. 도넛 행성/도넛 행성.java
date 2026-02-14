import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m;
    static int[][] map;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static boolean[][] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    bfs(i,j);
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    private static void bfs(int sx, int sy) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sx, sy});
        visited[sx][sy] = true;
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx == n) nx = 0;
                if(ny == m) ny = 0;
                if(nx == -1) nx = n-1;
                if(ny == -1) ny = m-1;
                if(map[nx][ny] == 0 && !visited[nx][ny]){
                    dq.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
