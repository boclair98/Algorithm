import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n,m,k;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int total = 0;
        boolean check = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && map[i][j] == 0){
                    int num = bfs(i,j);
                    total+=(num+k-1)/k;
                    check = true;
                }
            }
        }
        if(!check || total > m){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println("POSSIBLE");
            System.out.println(m-total);
        }
    }

    private static int bfs(int sx, int sy) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sx,sy});
        visited[sx][sy] = true;
        int count = 1;
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                if(!visited[nx][ny] && map[nx][ny] == 0){
                    count++;
                    visited[nx][ny] = true;
                    dq.add(new int[]{nx,ny});
                }
            }
        }
        return count;
    }
}