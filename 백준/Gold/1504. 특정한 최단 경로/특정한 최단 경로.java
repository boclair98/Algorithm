import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int v,e;
    static int[] dist;
    static List<List<int[]>> graph = new ArrayList<>();
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        for(int i = 0; i<=v; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<e; i++){
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
        long start1 = (long)dijkstart(1,s1) + (long)dijkstart(s1,s2) +(long)dijkstart(s2,v);
        long start2 = (long)dijkstart(1,s2) + (long)dijkstart(s2,s1) + (long)dijkstart(s1,v);
        if(Math.min(start1,start2) >= INF){
            System.out.println(-1);
        }else{
            System.out.println(Math.min(start1,start2));
        }
    }

    private static int dijkstart(int start,int end) {
        dist = new int[v+1];
        Arrays.fill(dist,INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1[1],o2[1]);
        });
        pq.add(new int[]{start,0});
        dist[start] = 0;
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int dists = cur[1];
            if(dists > dist[node]) continue;
            for(int[] now : graph.get(node)){
                int nextnode =now[0];
                int nextdist = dists + now[1];
                if(dist[nextnode] > nextdist){
                    dist[nextnode] = nextdist;
                    pq.add(new int[]{nextnode,nextdist});
                }
            }
        }
        return dist[end];
    }
}
