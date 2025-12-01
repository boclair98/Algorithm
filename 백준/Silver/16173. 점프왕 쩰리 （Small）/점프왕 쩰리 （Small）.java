import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] map;
    static StringTokenizer st;
    static int[] dx ={1,0};
    static int[] dy ={0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(bfs()){
            System.out.println("HaruHaru");
        }else{
            System.out.println("Hing");
        }
    }

    private static boolean bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0,0});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            if(x == n-1 && y == n-1)return true;
            int count = map[x][y];
            int ny = y + count;
            if(ny < n){
                if(x == n-1 && ny == n-1) return true;
                if(!visited[x][ny]){
                    visited[x][ny] = true;
                    dq.add(new int[]{x,ny});
                }
            }
            int nx = x + count;
            if(nx < n){
                if(nx == n-1 && y == n-1) return true;
                if(!visited[nx][y]){
                    visited[nx][y] = true;
                    dq.add(new int[]{nx,y});
                }
            }
        }
        return false;
    }
}
