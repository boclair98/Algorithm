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
    static int cnt, value,count;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //BFS
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    cnt = 0;
                    count++;
                    BFS(i,j);
                }
            }
        }
        System.out.println(count);
        System.out.println(value);
    }
    static void BFS(int z, int c){
        visited[z][c] = true;
        cnt++;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{z,c});
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx >= n || ny<0 || ny >= m){
                    continue;
                }
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    deque.add(new int[]{nx,ny});
                    cnt++;
                }
            }
        }
        value = Math.max(value,cnt);
    }


}

