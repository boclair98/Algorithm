import java.io.*;
import java.util.*;

public class Main {
    static int n,e;
    static StringTokenizer st;
    static List<List<int[]>> list;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        arr = new int[n+1];
        Arrays.fill(arr,Integer.MAX_VALUE);
        for(int i = 0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list.get(x).add(new int[]{y,dist});
//            list.get(y).add(new int[]{x,dist});
        }
        dijkstra(start);
        for(int i = 1; i<=n; i++){
            if(arr[i] ==Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(arr[i]);
            }
        }

    }
    static void dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
            return Integer.compare(o1[1],o2[1]);
        });
        arr[start] = 0;
        pq.add(new int[]{start,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int now = cur[0];
            int dist = cur[1];
            for(int[] next : list.get(now)){
                int nextNode = next[0];
                int nextDist = next[1];
                if(arr[nextNode] > arr[now] + nextDist){
                    arr[nextNode] = arr[now] + nextDist;
                    pq.add(new int[]{nextNode,arr[nextNode]});
                }
            }
        }

    }





}
