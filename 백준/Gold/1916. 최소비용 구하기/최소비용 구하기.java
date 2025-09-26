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
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i = 0; i<=n; i++ ){
            graph.add(new ArrayList<>());
        }
        arr = new int[n+1];
        Arrays.fill(arr,-1);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b,cost});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start,end);

    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1,o2) ->{
            return Integer.compare(o1[1],o2[1]);
        });
        arr[start] = 0;
        priorityQueue.add(new int[]{start,0});
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
        System.out.println(arr[end]);
    }
}
