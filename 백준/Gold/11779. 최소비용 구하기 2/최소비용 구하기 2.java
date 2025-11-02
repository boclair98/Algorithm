import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static StringTokenizer st;
    static List<List<int[]>> list;
    static int[] dist;
    static int[] prev;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n+1];
        prev = new int[n+1];
        list = new ArrayList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        for(int i = 0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b,c});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(dijk(start,end));
        List<Integer> path = new ArrayList<>();
        for(int i = end; i!=-1; i = prev[i]){
            path.add(i);
        }
        Collections.reverse(path);
        System.out.println(path.size());
        for (Integer i : path) {
            System.out.print(i+" ");
        }

    }

    private static int dijk(int start,int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) ->{
            return Integer.compare(o1[1],o2[1]);
        });
        pq.add(new int[]{start,0});
        dist[start] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int dists = cur[1];
            if(dist[node] < dists) continue;
            for(int[] next : list.get(node)){
                int nextNode = next[0];
                int nextDist = dists + next[1];
                if(dist[nextNode] > nextDist){
                    dist[nextNode] = nextDist;
                    prev[nextNode] = node;
                    pq.add(new int[]{nextNode,nextDist});
                }
            }
        }
        return dist[end];
    }
}
