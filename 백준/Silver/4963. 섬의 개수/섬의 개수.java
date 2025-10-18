import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int w,h;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0,-1,-1,1,1};
    static int[] dy = {0,1,0,-1,-1,1,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        st = new StringTokenizer(br.readLine());
        while(true){
            int total = 0;
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;
            map = new int[w][h];
            visited = new boolean[w][h];
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < h; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 0 ; i<w; i++){
                for(int j = 0; j<h; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        visited[i][j] = true;
                        bfs(i,j);
                        total++;
                    }
                }
            }
            System.out.println(total);
        }
    }

    private static void bfs(int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx,sy});
//        visited[sx][sy] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0],y = cur[1];
            for(int i = 0; i<8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || ny<0 || nx>=w || ny>=h) continue;
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }


}
