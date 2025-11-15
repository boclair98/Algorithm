import java.io.*;
import java.util.*;

public class Main {
    static int n,x,m;
    static int[] dist;
    static List<List<int[]>> graph = new ArrayList<>();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i <m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b,c});
        }
        int max_dist = 0;
        for(int i =1; i<=n; i++){
            int total = dijk(i,x) + dijk(x,i);
//            System.out.println(total);
            max_dist = Math.max(max_dist, total);
        }
        System.out.println(max_dist);
    }
    static int dijk(int start, int end){
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) ->{
            return Integer.compare(o1[1],o2[1]);
        });
        dist[start] = 0;
        pq.add(new int[]{start,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int nowNode = cur[0];
            int nowDist = cur[1];
            if(dist[nowNode] < nowDist) continue;
            for(int[] next : graph.get(nowNode)){
                int nextNode = next[0];
                int nextDist = next[1] + nowDist;
                if(dist[nextNode] > nextDist){
                    dist[nextNode] = nextDist;
                    pq.add(new int[]{nextNode,nextDist});
                }
            }
        }
        return dist[end];
    }

}
