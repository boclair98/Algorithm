import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n ;
    static int[][] map;
    static int[][] dist;
    static Queue<int[]> q;
    static boolean[][] visited;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static int problem = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        st = new StringTokenizer(br.readLine());
        while(true){
            n = Integer.parseInt(br.readLine());
            if(n == 0)break;
            map = new int[n][n];
            dist = new int[n][n];
            visited = new boolean[n][n];
            for(int i = 0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            q = new ArrayDeque<>();
            int tot_dist = dijkstra();
            
            System.out.println("Problem "+(problem++)+": "+tot_dist);

        }


    }

    private static int dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1,o2) ->{
                    return Integer.compare(o1[2],o2[2]);
                }
        );
        pq.add(new int[]{0,0,map[0][0]});
        dist[0][0] = map[0][0];
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int cost = cur[2];
            if(x == n-1 && y == n-1){
                return cost;
            }

            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                int newcost = map[nx][ny] + cost;
                if(newcost < dist[nx][ny]){
                    dist[nx][ny] = newcost;
                    pq.add(new int[]{nx,ny,newcost});
                }
            }

        }
        return -1;

    }
}
