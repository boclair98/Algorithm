import java.io.*;
import java.util.*;

public class Main {
    static int n,m,k;
    static StringTokenizer st;
    static List<List<int[]>> graph = new ArrayList<>();
    static int[][] dp = new int[400][400];
    static int recur(int idx, int cnt){
        if(idx == n) return 0;
        if(cnt >= m) return -Integer.MAX_VALUE;
        if(dp[idx][cnt] != -1) return dp[idx][cnt];
        int ans = -1000000000;
        for(int[] next : graph.get(idx)){
            int node = next[0];
            int cost = next[1];
            int total = recur(node,cnt+1);
            if(total != -Integer.MAX_VALUE){
                ans = Math.max(ans,cost+total);
            }
        }
        return dp[idx][cnt] = ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i <=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a<b){
                graph.get(a).add(new int[]{b,c});
            }
        }
        for(int i = 0; i < 400; i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(recur(1,1));
    }

}

