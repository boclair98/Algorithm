import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] map = new int[5][5];
    static HashSet<String> set = new HashSet<>();
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                dfs(i,j,"",0);
            }
        }
        System.out.println(set.size());
//        System.out.println(set);
    }

    private static void dfs(int i, int j, String s, int count) {
        if(count == 6){
            set.add(s);
            return;
        }
        for(int k = 0; k < 4; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(nx<0||ny<0||nx>=5||ny>=5)continue;
            dfs(nx,ny,s+map[nx][ny],count+1);
        }

    }
}
