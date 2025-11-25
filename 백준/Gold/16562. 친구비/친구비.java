import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m,k,v,w;
    static int[] cost;
    static int[] parents;
    static Set<Integer> set = new HashSet<>();
    static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            if(x < y){
                parents[y] =x;
            }else{
                parents[x] = y;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        cost = new int[n+1];
        parents = new int[n+1];
        for(int i = 1; i<=n; i++){
            parents[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        int total = 0;
        int[] min_cost = new int[n+1];
        Arrays.fill(min_cost,Integer.MAX_VALUE);
        for(int i = 1; i<=n; i++){
            int num = find(i);
            min_cost[num] = Math.min(min_cost[num],cost[i]);
        }
        for(int i = 1; i<=n; i++){
            if(i == parents[i]){
                total+=min_cost[i];
            }
        }


//        System.out.println(total);
        if(total > k){
            System.out.println("Oh no");
        }else{
            System.out.println(total);
        }
    }
}
