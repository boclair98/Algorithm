import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    
    static StringTokenizer st;
    static int test;
    static int n,m,t;
    static int s,g,h;
    static int[] dist;
    static List<List<int[]>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        test = Integer.parseInt(br.readLine());
        while(test-->0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            for(int i = 0; i<=n; i++){
                graph.add(new ArrayList<>());
            }
            for(int i = 0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph.get(a).add(new int[]{b,c});
                graph.get(b).add(new int[]{a,c});
            }
            int[] arr = new int[t];
            for(int i = 0; i<t; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
            List<Integer> answer = new ArrayList<>();
            for(int k : arr){
                int first = dijkstra(s,g) + dijkstra(g,h) + dijkstra(h,k);
                int second = dijkstra(s,h) + dijkstra(h,g) + dijkstra(g,k);
                int third = dijkstra(s,k);
                if(Math.min(first,second) == third){
                    answer.add(k);
                }
            }
            Collections.sort(answer);
            for(int c : answer){
                sb.append(c+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static int dijkstra(int start,int end){
        dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1[1],o2[1]);
        });
        pq.add(new int[]{start,0});
        dist[start] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int now = cur[0];
            int di = cur[1];
            if(dist[now] < di) continue;
            for(int[] next : graph.get(now)){
                int next_node = next[0];
                int next_dist = next[1] + di;
                if(dist[next_node] > next_dist){
                    dist[next_node] = next_dist;
                    pq.add(new int[]{next_node,next_dist});
                }
            }
        }
        return dist[end];
    }

}