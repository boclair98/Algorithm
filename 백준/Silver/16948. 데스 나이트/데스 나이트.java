import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int x,y,x1,y1;
    static int[] dx = {-2,-2,0,0,2,2};
    static int[] dy = {-1,1,-2,2,-1,1};
    static StringTokenizer st;
    static Queue<int[]> q;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        q = new ArrayDeque<>();
        q.add(new int[]{x,y,0});
        visited[x][y] = true;
        System.out.println(bfs());
    }
    static int bfs(){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int xx = cur[0];
            int yy = cur[1];
            int count  = cur[2];
            if(xx == x1 && yy == y1){
                return count;
            }
            for(int i = 0; i<6; i++){
                int nx = xx + dx[i];
                int ny = yy + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=n){
                    continue;
                }
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny,count+1});
                }

            }
        }
        return -1;
    }
}
