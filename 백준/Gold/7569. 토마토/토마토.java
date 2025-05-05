import java.io.*;
import java.util.*;

public class Main {
    static int n,m,h,total;
    static StringTokenizer st;
    static int[] dx ={0,1,0,-1,0,0};
    static int[] dy ={1,0,-1,0,0,0};
    static int[] dh ={0,0,0,0,-1,1};
    static boolean[][][] visited;
    static int[][][] map;
    static Queue<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[n][m][h];
        visited = new boolean[n][m][h];
        for(int i = 0; i<h; i++){
            for(int j = 0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k<m; k++){
                    map[j][k][i] = Integer.parseInt(st.nextToken());
                    if(map[j][k][i] == 1){
                        q.add(new int[]{j,k,i});
                    }
                }
            }
        }
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int h1 = cur[2];
            visited[x][y][h1] = true;
            for(int i = 0; i<6; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nh = h1 + dh[i];
                if(nx<0 || nx>=n || ny < 0 || ny >= m || nh < 0 || nh>=h) continue;
                if(!visited[nx][ny][nh] && map[nx][ny][nh] == 0){
                    visited[nx][ny][nh] = true;
                    map[nx][ny][nh] = map[x][y][h1] + 1;
                    q.add(new int[]{nx,ny,nh});
                }
            }
        }
        boolean zero = false;
        int max_val = 0;
        for(int i = 0; i<h; i++){
            for(int j = 0; j<n; j++){
                for(int k = 0; k<m; k++){
                    if(map[j][k][i] == 0){
                        zero = true;
                        break;
                    }else{
                        max_val = Math.max(max_val,map[j][k][i]);
                    }
                }

            }
        }
        if(zero){
            System.out.println(-1);
        }else{
            System.out.println(max_val-1);
        }

    }

}
