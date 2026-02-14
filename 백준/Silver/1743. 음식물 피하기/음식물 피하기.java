import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n,m,d,max_size;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i <d; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x-1][y-1] = 1;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    int size = bfs(i,j);
                    max_size = Math.max(size,max_size);
                }
            }
        }
        System.out.println(max_size);
    }

    private static int bfs(int sx, int sy) {
        int cnt = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sx,sy});
        cnt++;
        visited[sx][sy] = true;
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0||nx>=n || ny<0 || ny>=m) continue;
                if(!visited[nx][ny] && map[nx][ny] == 1){
                    cnt++;
                    visited[nx][ny] = true;
                    dq.add(new int[]{nx,ny});
                }
            }
        }
        return cnt;
    }

}