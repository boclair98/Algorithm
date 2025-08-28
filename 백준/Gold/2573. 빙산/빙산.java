import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m ;
    static boolean[][] visited;
    static int[][] maps;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static StringTokenizer st;
    static int turn;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maps = new int[n][m];
        queue = new ArrayDeque<>();
        for(int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                maps[i][j] = Integer.parseInt(st.nextToken());
                if(maps[i][j] > 0) queue.offer(new int[]{i,j});
            }
        }
        while(true){
            int no = 0;
            for(int i = 0; i< n ; i++){
                for(int j = 0; j<m; j++){
                    if(maps[i][j] == 0) no++;
                }
            }
            if(no == n*m){
                System.out.println(0);
                return;
            }
            int count = check();
            if(count>=2) break;
            int[][] melts = new int[n][m];
            while(!queue.isEmpty()){
                int total = 0;
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for(int i = 0; i<4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                    if(maps[nx][ny] == 0) total++;
                }
                melts[x][y] = Math.max(0,maps[x][y]-total);
            }
            maps = melts;
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    if(maps[i][j] > 0) queue.offer(new int[]{i,j});
                }
            }
            turn++;
        }
        System.out.println(turn);
    }

    public static int check(){
        visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!visited[i][j] && maps[i][j] > 0){
                    visited[i][j] = true;
                    q.offer(new int[]{i,j});
                    count++;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int x = cur[0];
                        int y = cur[1];
                        for(int k = 0; k<4; k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                            if(!visited[nx][ny] && maps[nx][ny] > 0){
                                q.offer(new int[]{nx,ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
