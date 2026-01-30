import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n,e;
    static List<List<int[]>> list = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        for(int i = 0; i <=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            list.get(start).add(new int[]{end,distance});
            list.get(end).add(new int[]{start,distance});
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        long path1 = (long) dijkstra(1,a) + (long) dijkstra(a,b) + (long) dijkstra(b,n);
        long path2 = (long) dijkstra(1,b) + (long) dijkstra(b,a) + (long) dijkstra(a,n);
        long answer = Math.min(path1,path2);
        if(answer >= 1000000000) System.out.println(-1);
        else System.out.println(answer);
    }
    static int dijkstra(int num,int end){
        dist = new int[n+1];
        Arrays.fill(dist,1000000000);
        dist[num] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1[1],o2[1]);
        });
        pq.add(new int[]{num,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int dists = cur[1];
            if(dists > dist[node]) continue;
            for(int[] next : list.get(node)){
                int next_node = next[0];
                int next_dist = dists + next[1];
                if(dist[next_node] > next_dist){
                    dist[next_node] = next_dist;
                    pq.add(new int[]{next_node,next_dist});
                }
            }
        }
        return dist[end];
    }
}