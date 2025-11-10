import java.io.*;
import java.util.*;

public class Main {
    static int n,d;
    static StringTokenizer st;
    static int[] dist;
    static List<List<int[]>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        dist = new int[d+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i = 0; i<=d; i++){
            graph.add(new ArrayList<>());
        }
        for(int i =0; i<d; i++){
            graph.get(i).add(new int[]{i+1,1});
        }
        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (b <= d) {
                graph.get(a).add(new int[]{b, c});
            }
        }
        dijk(0);
        System.out.println(dist[d]);

    }

    private static void dijk(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) ->{
            return Integer.compare(o1[1],o2[1]);
        });
        dist[start] = 0;
        pq.add(new int[]{start,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int now = cur[0];
            int dis = cur[1];
            if(dist[now] < dis)continue;
            for(int[] node : graph.get(now)){
                int nextNode = node[0];
                int nextDis = node[1] + dis;
                if(dist[nextNode] > nextDis){
                    dist[nextNode] = nextDis;
                    pq.add(new int[]{nextNode,nextDis});
                }
            }
        }

    }

}
