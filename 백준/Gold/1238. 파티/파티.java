import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n, m,x;
    static int[] dist;
    static List<List<int[]>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(x).add(new int[]{y,cost});
        }
        int max_dist = 0;
        for(int i = 1; i<=n; i++){
            max_dist = Math.max(max_dist,dijkstra(i,x)+dijkstra(x,i));
//            System.out.println(max_dist);
        }
        System.out.println(max_dist);
    }
    static int dijkstra(int start, int end){
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1[1],o2[1]);
        });
        dist[start] = 0;
        pq.add(new int[]{start,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            if(dist[node] < cost) continue;
            for(int[] next : graph.get(node)){
                int nextNode = next[0];
                int nextCost = cost + next[1];
                if(dist[nextNode] > nextCost){
                    dist[nextNode] = nextCost;
                    pq.add(new int[]{nextNode,nextCost});
                }
            }
        }
        return dist[end];
    }





}
