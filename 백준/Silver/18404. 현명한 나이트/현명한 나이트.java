import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m;
    static int[] dx ={-2,-2,-1,-1,1,1,2,2};
    static int[] dy ={-1,1,-2,2,-2,2,-1,1};
    static boolean[][] visited1;
    static boolean[][] visited2;
    static int[][] count;
    static int sx,sy = 0;
    static Deque<int[]> dq = new ArrayDeque<>();
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken())-1;
        sy = Integer.parseInt(st.nextToken())-1;
        visited1 = new boolean[n][n];
        visited2 = new boolean[n][n];
        count = new int[n][n];
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            visited2[x-1][y-1] = true;
            list.add(new int[]{x-1,y-1});
        }
        bfs();
        for(int i = 0; i<list.size(); i++){
            System.out.print(count[list.get(i)[0]][list.get(i)[1]]+" ");
        }
    }

    private static void bfs() {
        dq.add(new int[]{sx,sy,0});
        visited1[sx][sy] = true;
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            int counts = cur[2];
            if(visited2[x][y] && count[x][y] == 0){
                count[x][y] = counts;
            }
            for(int i = 0; i<8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                if(!visited1[nx][ny]){
                    visited1[nx][ny] = true;
                    dq.add(new int[]{nx,ny,counts+1});
                }
            }
        }

    }
}
