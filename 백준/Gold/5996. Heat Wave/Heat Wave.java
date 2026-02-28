import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int t,c,ts,te;
    static int[] dist;
    static List<List<int[]>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        ts = Integer.parseInt(st.nextToken());
        te = Integer.parseInt(st.nextToken());
        dist = new int[t+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0; i <=t; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < c; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b,c});
            graph.get(b).add(new int[]{a,c});
        }
        System.out.println(dijkstra(ts,te));
    }
    static int dijkstra(int start, int end){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1[1],o2[1]);
        });
        pq.add(new int[]{start,0});
        dist[start] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int dists = cur[1];
            if(dist[node] < dists) continue;
            for(int[] next : graph.get(node)){
                int next_node = next[0];
                int next_dist = next[1] + dists;
                if(dist[next_node] > next_dist){
                    dist[next_node] = next_dist;
                    pq.add(new int[]{next_node,next_dist});
                }
            }
        }
        return dist[end];
    }
}
