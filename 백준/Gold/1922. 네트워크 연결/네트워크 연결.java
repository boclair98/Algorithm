import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n,m;
    static StringTokenizer st;
    static int[] parents;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
        return Integer.compare(o1[2],o2[2]);
    });
    static int find(int x){
        if(parents[x]==x) return x;
        return parents[x] = find(parents[x]);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parents[y] = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        parents = new int[n+1];
        for(int i = 1; i<=n; i++){
            parents[i] = i;
        }
        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a,b,c});
        }
        int disantce = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int coin = cur[2];
            if(find(x)!=find(y)){
                union(x, y);
                disantce+=coin;
            }
        }
        System.out.println(disantce);
    }
}


