import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            String number = br.readLine();
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(number.charAt(j)+"");
            }
        }
        System.out.println(bfs());
//        for(int i = 0; i<n; i++){
//            for(int j = 0; j<m; j++){
//                System.out.print(dist[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
    public static int bfs(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1[2],o2[2]);
        });
        pq.add(new int[]{0,0,0});
        visited[0][0] = true;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            if(x == n-1 && y == m-1){
                return count;
            }
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(map[nx][ny] == 0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    pq.add(new int[]{nx,ny,count});
                }
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    pq.add(new int[]{nx,ny,count+1});
                }
            }
        }
        return 0;
    }
}
