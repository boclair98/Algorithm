import javax.imageio.ImageTranscoder;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m,count;
    static boolean[][] visited;
    static char[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            String word = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = word.charAt(j);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && map[i][j] == '*'){
                    count++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(count);
    }

    private static void bfs(int s, int y) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {s,y});
        visited[s][y] = true;
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int x1 = cur[0];
            int y1 = cur[1];
            for(int i = 0; i < 4; i++){
                int nx = x1 + dx[i];
                int ny = y1 + dy[i];
                if(nx < 0 || nx>=n || ny < 0 || ny >= m) continue;
                if(!visited[nx][ny] && map[nx][ny] =='*'){
                    dq.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
