import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][k+1];
        for(int i = 0; i<n; i++){
            String word = br.readLine();
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(word.charAt(j)+"");
            }
        }
        int answer = bfs(0,0,1,0);
        System.out.println(answer);
    }

    private static int bfs(int sx, int sy, int dist, int broken) {
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{sx,sy,dist,broken});
            visited[sx][sy][broken] = true;
            while (!q.isEmpty()){
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int distance = cur[2];
                int brokens = cur[3];
                if(x == n-1 && y == m-1){
                    return distance;
                }
                for(int i = 0; i<4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                    if(map[nx][ny] == 0 && !visited[nx][ny][brokens]){
                        visited[nx][ny][brokens] = true;
                        q.offer(new int[]{nx,ny,distance+1,brokens});
                    }
                    if(map[nx][ny] == 1 && brokens < k && !visited[nx][ny][brokens]){
                        visited[nx][ny][brokens] = true;
                        q.offer(new int[]{nx,ny,distance+1,brokens+1});
                    }
                }
            }
            return -1;

    }

}