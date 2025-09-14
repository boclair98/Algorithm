import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static char[][] map;
    static boolean[][] visited;
    static StringTokenizer st;
    static int[] dx ={0,1};
    static int[] dy ={1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            String word = br.readLine();
            for(int j = 0; j<m; j++){
                map[i][j] = word.charAt(j);
            }
        }
        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!visited[i][j]){
                    bfs(i,j,map[i][j]);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(int sx, int sy,char c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx,sy});
        visited[sx][sy] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(c=='-'){
                int nx = x + dx[0];
                int ny = y + dy[0];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(!visited[nx][ny] && map[nx][ny] =='-'){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }

            if(c =='|'){
                int nx = x + dx[1];
                int ny = y + dy[1];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(!visited[nx][ny] && map[nx][ny] =='|'){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
}
