import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int t,n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(br.readLine());
        while(t-->0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            int cnt = 0;
            for(int i = 0; i < n; i++){
                String word = br.readLine();
                for(int j = 0; j<m; j++){
                    if(word.charAt(j) =='#'){
                        map[i][j] = 1;
                    }
                }
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }

    }

    private static void bfs(int sx, int sy) {
        visited[sx][sy] = true;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sx,sy});
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx>=n || ny<0 || ny>=m) continue;
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    dq.add(new int[]{nx,ny});
                }
            }
        }
    }
}