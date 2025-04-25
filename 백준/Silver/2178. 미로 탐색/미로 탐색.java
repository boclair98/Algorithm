import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int n,m;
    static int[][] map;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static boolean[][] visited;
    static int distance;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            String word = br.readLine();
            for(int j = 0; j<m; j++){
                map[i][j] = word.charAt(j)-'0';
            }
        }
        //BFS
        BFS(0,0);
        System.out.println(map[n-1][m-1]);

    }
    static void BFS(int z,int c){
        visited[z][c] = true;
        Deque<int[]> d = new ArrayDeque<>();
        d.add(new int[]{z,c});
        while(!d.isEmpty()){
            int[] cur = d.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    map[nx][ny] = map[x][y] + 1;
                    visited[nx][ny] = true;
                    d.add(new int[]{nx,ny});
                }
            }
        }
    }



}

