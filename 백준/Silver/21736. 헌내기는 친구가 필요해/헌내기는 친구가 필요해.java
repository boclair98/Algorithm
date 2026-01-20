import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m, cnt;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static void bfs(int sx, int sy){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx,sy});
        visited[sx][sy] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx>=n || ny < 0 || ny >=m) continue;
                if(!visited[nx][ny] && map[nx][ny] == 'P'){
                    cnt++;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
                if(!visited[nx][ny] && map[nx][ny] == 'O'){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            String w = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = w.charAt(j);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j <m; j++){
                if(map[i][j] == 'I'){
                    bfs(i,j);
                }
            }
        }
        if(cnt > 0){
            System.out.println(cnt);
        }else{
            System.out.println("TT");
        }
    }
}