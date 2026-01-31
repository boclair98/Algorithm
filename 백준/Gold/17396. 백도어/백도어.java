import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n,m;
    static List<List<long[]>> graph = new ArrayList<>();
    static long[] dist;
    static long[] cost;
    static long dijkstra(int start, int end){
        dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1,o2)->{
            return Long.compare(o1[1],o2[1]);
        });
        pq.add(new long[]{start,0});
        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            int node = (int) cur[0];
            long dists = cur[1];
            if(dist[node] < dists) continue;
            for(long[] next : graph.get(node)){
                int next_node = (int) next[0];
                if(next_node != n-1 && cost[next_node] == 1) continue;
                long next_dists = next[1] + dists;
                if(dist[next_node] > next_dists){
                    dist[next_node] = next_dists;
                    pq.add(new long[]{next_node,next_dists});
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
        cost = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new long[]{b,c});
            graph.get(b).add(new long[]{a,c});
        }
        long answer = dijkstra(0,n-1);
        if(answer == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);

    }
}