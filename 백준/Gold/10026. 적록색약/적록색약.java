import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int n;
    static char[][] maps;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int count1, count2;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       n = Integer.parseInt(br.readLine());
       maps = new char[n][n];
       for(int i = 0; i<n; i++){
           String s = br.readLine();
           for(int j = 0; j<n; j++){
               maps[i][j] = s.charAt(j);
           }
       }
       visited = new boolean[n][n];
       for(int i = 0; i<n; i++){
           for(int j = 0; j<n; j++){
               if(!visited[i][j]){
                   count1++;
                   bfs(i,j,maps[i][j]);
               }
           }
       }
       visited = new boolean[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(!visited[i][j]){
                    count2++;
                    bfs2(i,j,maps[i][j]);
                }
            }
        }
        System.out.println(count1+" "+count2);
    }

    private static void bfs2(int sx, int sy, char color) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx,sy});
        visited[sx][sy] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=n)continue;
                if(color == 'R' || color == 'G'){
                    if(!visited[nx][ny] && (maps[nx][ny] == 'R' || maps[nx][ny] == 'G')){
                        q.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }else{
                    if(!visited[nx][ny] && maps[nx][ny] == 'B'){
                        q.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void bfs(int sx, int sy, char color){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx,sy});
        visited[sx][sy] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=n)continue;
                if(maps[nx][ny] == color && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }


}

