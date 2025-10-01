import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,count;
    static boolean[] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,1,0);
        System.out.println(count);

    }

    private static void dfs(int x, int y, int dir) {
        if(x == n-1 && y == n-1){
            count++;
            return;
        }
        if(dir == 0 || dir ==2){
            if(y+1<n && map[x][y+1] == 0){
                dfs(x,y+1,0);
            }
        }
        if(dir == 1 || dir ==2){
            if(x+1<n && map[x+1][y] == 0){
                dfs(x+1,y,1);
            }
        }
        if(x+1<n && y+1<n && map[x+1][y+1] == 0 && map[x+1][y] == 0 && map[x][y+1] == 0){
            dfs(x+1,y+1,2);
        }


    }

}
