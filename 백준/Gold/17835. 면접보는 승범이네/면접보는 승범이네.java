import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static long[] dist;
    static List<List<long[]>> graph = new ArrayList<>();
    static PriorityQueue<long[]> pq = new PriorityQueue<>((o1,o2)->{
        return Long.compare(o1[1],o2[1]);
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            graph.get(b).add(new long[]{a,c});
        }
        dist = new long[n+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<k; i++){
            int num = Integer.parseInt(st.nextToken());
            pq.add(new long[]{num,0});
            dist[num] = 0;
        }
        dijkstra();
        long number = -1;
        long max_dist = -1;
        for(int i =1; i<=n; i++){
            if(dist[i] > max_dist){
                number = i;
                max_dist = dist[i];
            }
        }
        System.out.println(number);
        System.out.println(max_dist);
    }
    static void dijkstra(){
        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            int now = (int)cur[0];
            long di = cur[1];
            if(dist[now] < di) continue;
            for(long[] next : graph.get(now)){
                int node = (int)next[0];
                long next_di = di + next[1];
                if(dist[node] > next_di){
                    dist[node] = next_di;
                    pq.add(new long[]{node,next_di});
                }
            }
        }
    }
}