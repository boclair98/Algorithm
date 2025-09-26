import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static StringTokenizer st;
    static int[] arr;
    static List<List<int[]>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        int start = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        Arrays.fill(arr,Integer.MAX_VALUE);
        for(int i = 0 ; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b,c});
        }
        dijkstra(start);
        for(int i = 1; i<=n; i++){
            if(arr[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(arr[i]);
            }
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1[1],o2[1]);
        });
        priorityQueue.add(new int[]{start,0});
        arr[start] = 0;
        while(!priorityQueue.isEmpty()){
            int[] cur = priorityQueue.poll();
            int node = cur[0];
            int cost = cur[1];
            if(arr[node] < cost) continue;
            for(int[] next : graph.get(node)){
                int nextnode = next[0];
                int nextcost = next[1] + cost;
                if(arr[nextnode] == -1 || arr[nextnode] > nextcost){
                    arr[nextnode] = nextcost;
                    priorityQueue.offer(new int[]{nextnode,nextcost});
                }
            }
        }
    }


}
