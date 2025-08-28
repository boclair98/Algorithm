import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int n,m ;
    static int[] dx ={1,0,-1,0,-1,1,-1,1};
    static int[] dy ={0,1,0,-1,-1,-1,1,1};
    static int[][] maps;
    static boolean[][] visited;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       while(true){
           st = new StringTokenizer(br.readLine());
           m = Integer.parseInt(st.nextToken());
           n = Integer.parseInt(st.nextToken());
           if(n == 0 && m == 0) break;
           maps = new int[n][m];
           visited = new boolean[n][m];
           int count = 0;
           for(int i = 0 ; i<n; i++){
               st = new StringTokenizer(br.readLine());
               for(int j = 0; j<m; j++){
                   maps[i][j] = Integer.parseInt(st.nextToken());
               }
           }
           for(int i = 0; i < n; i++){
               for(int j = 0; j<m; j++){
                   if(maps[i][j] == 1 && !visited[i][j]){
                       count++;
                       bfs(i,j);
                   }
               }
           }
           System.out.println(count);

       }


    }

    private static void bfs(int x1, int y1) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x1,y1});
        visited[x1][y1] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i<8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if(maps[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }

        }
    }
}

