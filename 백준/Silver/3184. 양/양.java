import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m ;
    static boolean[][] visited;
    static char[][] maps;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static StringTokenizer st;
    static int fox,sheep;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maps = new char[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            String word = br.readLine();
            for(int j = 0; j<m; j++){
                maps[i][j] = word.charAt(j);
                if(maps[i][j] == 'o'){
                    sheep++;
                }else if(maps[i][j] =='v'){
                    fox++;
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(maps[i][j] == 'o' || maps[i][j] == 'v' &&(!visited[i][j])){
                    bfs(i,j);
                }
            }
        }
        System.out.println(sheep+" "+fox);

    }

    private static void bfs(int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        int s = 0, f = 0;
        if(maps[sx][sy] == 'o'){
            s++;
        }else{
            f++;
        }
        q.add(new int[]{sx,sy});
        visited[sx][sy] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(maps[nx][ny] == 'o' && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                    s++;
                }else if(maps[nx][ny] == 'v' && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                    f++;
                }else if(maps[nx][ny] == '.' && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        if(s > f){
            fox-=f;
        }else{
            sheep-=s;
        }
    }
}
