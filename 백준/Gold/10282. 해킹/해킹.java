import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int t;
    static int n,d,c,cnt;
    static int[] dist;
    static List<List<int[]>> list;
    static void dijkstra(int start){
        dist = new int[n+1];
        Arrays.fill(dist,1000000000);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) ->{
            return Integer.compare(o1[1],o2[1]);
        });
        pq.add(new int[]{start,0});
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int dists = cur[1];
            if(dist[node] < dists) continue;
            for(int[] next : list.get(node)){
                int next_node = next[0];
                int next_dist = dists + next[1];
                if(dist[next_node] > next_dist){
                    dist[next_node] = next_dist;
                    pq.add(new int[]{next_node,next_dist});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while(t -- > 0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for(int i = 0; i <=n; i++){
                list.add(new ArrayList<>());
            }
            for(int i = 0; i < d; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
//                list.get(a).add(new int[]{b,c});
                list.get(b).add(new int[]{a,c});
            }
            cnt = 0;
            int max_time = 0;
            dijkstra(c);
            for(int i = 1; i<=n; i++) {
                if(dist[i] != 1000000000){
                    cnt++;
                    max_time = Math.max(max_time,dist[i]);
                }
            }
            System.out.println(cnt+" "+max_time);

        }

    }
}