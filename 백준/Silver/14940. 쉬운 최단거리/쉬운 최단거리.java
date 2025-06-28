import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n , m;
    static int[][] result, maps;
    static boolean[][] visited;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static int startx, starty;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[n][m];
        maps = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                maps[i][j] = Integer.parseInt(st.nextToken());
                if(maps[i][j] == 2){
                    startx = i;
                    starty = j;
                }
            }
        }

        result[startx][starty] = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startx,starty});
        visited[startx][starty] = true;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >=n || ny >=m) continue;
                if(maps[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    result[nx][ny] = result[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(maps[i][j] == 0){
                    System.out.print(0+" ");
                }else if(!visited[i][j]){
                    System.out.print(-1+" ");
                }else{
                    System.out.print(result[i][j]+" ");
                }
            }
            System.out.println();
            
        }
    }
}