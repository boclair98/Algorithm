import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m,cnt;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0; i<n; i++){
            String num = br.readLine();
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(String.valueOf(num.charAt(j)));
            }
        }

        for(int i = 0; i<m; i++){
            visited = new boolean[n][m];
            if(!visited[0][i] && map[0][i] == 0){
                visited[0][i] = true;
                if(bfs(0,i)) {
                    System.out.println("YES");
                    cnt++;
                    break;
                }
            }
        }
        if(cnt == 0){
            System.out.println("NO");
        }

    }

    private static boolean bfs(int sx, int sy) {
        Deque<int[]> dq  = new ArrayDeque<>();
        dq.add(new int[]{sx,sy});
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            if(x == n-1) return true;
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m)continue;
                if(!visited[nx][ny] && map[nx][ny] == 0){
                    visited[nx][ny] = true;
                    dq.add(new int[]{nx,ny});
                }
            }
        }
        return false;
    }
}
