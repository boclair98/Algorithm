import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m;
    static int[][] map;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static int answer = 0;
    static int count = 0;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            if(cheeze()){
                answer++;
                bfs(0,0);
            }else{
                break;
            }
        }
        System.out.println(answer);
        System.out.println(count);
    }
    static void bfs(int sx,int sy){
        count = 0;
        visited = new boolean[n][m];
        visited[sx][sy] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {sx,sy});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(!visited[nx][ny] && map[nx][ny] == 0){
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
                if(!visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    map[nx][ny] = 2;
                }
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == 2){
                    map[i][j] = 0;
                    count++;
                }
            }
        }

    }

    static boolean cheeze(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == 1) return true;
            }
        }
        return false;
    }


}
