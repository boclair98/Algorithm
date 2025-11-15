import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m,r;
    static List<List<int[]>> graph = new ArrayList<>();
    static int[] dist;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        dist = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b,c});
            graph.get(b).add(new int[]{a,c});
        }
        int max_val = 0;
        for(int i = 1; i<=n; i++){
            dijk(i);
            int total = 0;
            total+=dist[i];
            for(int j = 1; j<=n; j++){
                if(i == j) continue;
                if(distance[j] <= m){
                    total+=dist[j];
                }
            }
            max_val = Math.max(max_val,total);
        }
        System.out.println(max_val);
    }
    static void dijk(int start){
        distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) ->{
            return Integer.compare(o1[1],o2[1]);
        });
        distance[start] = 0;
        pq.add(new int[]{start,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int di = cur[1];
            if(distance[node] < di) continue;

            for(int[] nodes : graph.get(node)){
                int next_node = nodes[0];
                int next_distance = di + nodes[1];
                if(distance[next_node] > next_distance){
                    distance[next_node] = next_distance;
                    pq.add(new int[]{next_node,next_distance});
                }
            }
        }
    }
}
