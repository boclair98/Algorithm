import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n, m;
    static int[] dist;
    static List<List<int[]>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0 ;i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i  = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(x).add(new int[]{y,cost});
            graph.get(y).add(new int[]{x,cost});
        }
        dijkstra(1);
        System.out.println(dist[n]);
    }
    static void dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1[1],o2[1]);
        });
        pq.add(new int[]{start,0});
        dist[start] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int next = cur[0];
            int cost = cur[1];
            if(dist[next] < cost) continue;
            for(int[] node : graph.get(next)){
                int nextnode = node[0];
                int nextcost = node[1] + cost;
                if(dist[nextnode] > nextcost){
                    dist[nextnode] = nextcost;
                    pq.add(new int[]{nextnode,nextcost});
                }

            }
        }
    }




}
