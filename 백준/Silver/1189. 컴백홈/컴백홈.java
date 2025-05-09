import java.io.*;
import java.util.*;

public class Main {
    static int n,m,k,total;
    static Character[][] map;
    static boolean[][] visited;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new Character[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            String word = br.readLine();
            for(int j = 0; j<m; j++){
                map[i][j] = word.charAt(j);
            }
        }
        visited[n-1][0] = true;
        DFS(n-1,0,1);
        System.out.println(total);
    }

    private static void DFS(int x, int y, int idx) {
        if(x == 0 && y == m-1){
//            System.out.println(idx);
            if(idx == k){
                total++;
            }
            return;
        }
        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >=n || ny < 0 || ny>=m) continue;
            if(!visited[nx][ny] && map[nx][ny] =='.'){
                visited[nx][ny] = true;
                DFS(nx,ny,idx+1);
                visited[nx][ny] = false;
            }
        }
    }
}
