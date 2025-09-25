import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m,k;
    static StringTokenizer st;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static int[][] maps;
    static boolean[][] visited;
    static int max_val = -Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        maps = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(max_val);
    }

    private static void dfs(int cnt,int total) {
        if(cnt == k){
            max_val = Math.max(max_val,total);
            return;
        }
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                if(!visited[i][j]){

                    boolean check = true;
                    for(int k = 0; k<4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if((nx>=0 && nx<n && ny>=0 && ny<m) && visited[nx][ny]){
                            check = false;
                            break;
                        }
                    }
                    if(check){
                        visited[i][j] = true;
                        dfs(cnt+1,total+maps[i][j]);
                        visited[i][j] = false;
                    }

                }
            }
        }
    }
}
