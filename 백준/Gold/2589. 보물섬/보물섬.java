import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            String word = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = word.charAt(j);
            }
        }
        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 'L'){
                    visited = new boolean[n][m];
                    int ans = bfs(i,j);
                    answer = Math.max(answer,ans);
                }
            }
        }
        System.out.println(answer);

    }

    private static int bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy,0});
        visited[sx][sy] = true;
        int di = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            di = dist;
            for(int i = 0 ; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx>=n || ny < 0 || ny>=m) continue;
                if(map[nx][ny] == 'L' && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny,dist+1});
                }
            }
        }
        return di;
    }
}