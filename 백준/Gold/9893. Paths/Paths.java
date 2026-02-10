import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n, m;
    static int [] distance, cost;
    static List<List<int[]>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cost = new int[n+1];
        distance = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        Arrays.fill(cost, Integer.MAX_VALUE);
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b,c});
        }
        dijkstra();
        System.out.println(cost[1]);
    }
    static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) ->{
            if(o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[2], o2[2]);
        });
        pq.add(new int[]{0,0,0});
        distance[0] = 0;
        cost[0] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int dists = cur[1];
            int costs = cur[2];
            if(dists > distance[x]) continue;
            if(dists == distance[x] && costs > cost[x])continue;
            for(int[] node : graph.get(x)){
                int next_node = node[0];
                int next_dist = dists + 1;
                int next_cost = node[1] + costs;

                if(next_dist < distance[next_node]){
                    distance[next_node] = next_dist;
                    cost[next_node] = next_cost;
                    pq.add(new int[]{next_node,next_dist,next_cost});
                }else if(next_dist == distance[next_node] && next_cost < cost[next_node]){
                    cost[next_node] = next_cost;
                    pq.add(new int[]{next_node,next_dist,next_cost});
                }

            }

        }

    }
}
