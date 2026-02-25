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
    static boolean[][] visited;
    static int[] dx = {1,0};
    static int[] dy = {0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(bfs(0,0)) {
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    private static boolean bfs(int sx, int sy) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sx, sy});
        visited[sx][sy] = true;
        while(!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            if(x == n-1 && y == m-1){
                return true;
            }
            for(int i = 0; i < 2; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dq.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}
