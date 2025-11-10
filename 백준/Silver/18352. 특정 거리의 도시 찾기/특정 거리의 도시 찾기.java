import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m,k,x;
    static int[] dist;
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        Arrays.fill(dist,-1);
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
        }
        dijk(x);
        boolean found = false;
        for(int i =1; i<=n; i++){
            if(dist[i] == k){
                found = true;
                System.out.println(i);
            }
        }
        if(!found){
            System.out.println(-1);
        }

    }
    static void dijk(int start){
        Queue<Integer> pq = new ArrayDeque<>();
        pq.add(start);
        dist[start] = 0;
        while(!pq.isEmpty()){
            int now = pq.poll();
            for(Integer node : graph.get(now)){
                if(dist[node]== -1){
                    dist[node] = dist[now] + 1;
                    pq.add(node);
                }
            }
        }
    }
}
