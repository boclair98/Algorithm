import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,cnt,answer ;
    static int[][] map;
    static boolean[][] visited;
    static int[][] check;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        check = new int[n][n];
        cnt = 1;
        answer = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    bfs(i,j,cnt++);
                }
            }
        }

//        for(int i = 0; i<n; i++){
//            for(int j = 0; j<n; j++){
//                System.out.print(check[i][j]+" ");
//            }
//            System.out.println();
//        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(check[i][j] > 0){
                    answer = Math.min(answer,moves(i,j));

                }
            }
        }
        System.out.println(answer);

    }

    private static int moves(int sx, int sy) {
        visited = new boolean[n][n];
//        int count = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx,sy,0});
        visited[sx][sy] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n ||ny<0 || ny>=n) continue;
                if (check[nx][ny] != 0 && check[nx][ny] != check[sx][sy]) {
                    return count;
                }
                if(check[nx][ny] == 0 && !visited[nx][ny]){
                    q.add(new int[]{nx,ny,count+1});
                    visited[nx][ny] = true;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    //대륙별 파악
    private static void bfs(int sx, int sy, int cnt) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx,sy,cnt});
        visited[sx][sy] = true;
        check[sx][sy] = cnt;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    q.add(new int[]{nx,ny,cnt});
                    visited[nx][ny] = true;
                    check[nx][ny] = cnt;
                }
            }
        }
    }


}

