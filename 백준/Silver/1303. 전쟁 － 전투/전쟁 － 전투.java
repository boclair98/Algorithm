import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int n,m;
    static char[][] maps;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int wCount, bCount;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       st = new StringTokenizer(br.readLine());
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());
       maps = new char[m][n];
       visited = new boolean[m][n];
       wCount = 0;
       bCount = 0;
       for(int i = 0; i<m; i++){
           String word = br.readLine();
           for(int j = 0; j<n; j++){
               maps[i][j] = word.charAt(j);
           }
       }

       for(int i = 0 ; i < m ; i++){
           for(int j = 0; j < n; j++){
               if(maps[i][j] == 'W' && !visited[i][j]){
                   int cnt = bfs(i,j,maps[i][j]);
                   wCount += (cnt * cnt);
               }
               if(maps[i][j] == 'B' && !visited[i][j]){
                   int cnt = bfs(i,j,maps[i][j]);
                   bCount += (cnt * cnt);
               }
           }
       }
        System.out.println(wCount+" "+bCount);


    }

    private static int bfs(int x, int y,char word) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        int count = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];
            for(int i = 0; i < 4; i++){
                int nx = x1 + dx[i];
                int ny = y1 + dy[i];
                if(nx<0 || nx>=m || ny<0 || ny>=n) continue;
                if(maps[nx][ny] == word && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    count++;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return count;

    }
}

