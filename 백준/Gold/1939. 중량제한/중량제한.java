import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n,m;
    static List<List<int[]>> graph = new ArrayList<>();
    static int[] dist;
    static int dijkstra(int start, int end){
        dist = new int[n+1];
        Arrays.fill(dist,-1);
        dist[start] = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o2[1],o1[1]);
        });
        pq.add(new int[]{start,Integer.MAX_VALUE});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int dists = cur[1];
            if(dist[node] > dists) continue;
            for(int[] next : graph.get(node)){
                int next_node = next[0];
                int next_dist = Math.min(dists,next[1]);
                if(dist[next_node] < next_dist){
                    dist[next_node] = next_dist;
                    pq.add(new int[]{next_node,next_dist});
                }
            }
        }
        return dist[end];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i <=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b,c});
            graph.get(b).add(new int[]{a,c});
        }
        st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
//        long a = (long)dijkstra(1,s1) + (long)dijkstra(s1,s2) + (long) dijkstra(s2,n);
//        long b = (long)dijkstra(1,s2) + (long)dijkstra(s2,s1) + (long) dijkstra(s1,n);
        System.out.println(dijkstra(s1,s2));
    }
}