import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m;
    static int[] arr = new int[45];
    static boolean[] visited = new boolean[45];
    static boolean[] visited2 = new boolean[45];
    static int[] dp = new int[45];
    static int recur(int idx){
        if(idx <=1) return 1;
        if(idx == 2) return 2;
        if(dp[idx]!=-1) return dp[idx];
        return dp[idx] = recur(idx-1)+recur(idx-2);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        Arrays.fill(dp, -1);
        int ans = 1;
        int last = 0;
        for(int i = 0; i < m; i++){
            int num = Integer.parseInt(br.readLine());
            ans*= recur(num-last-1);
            last = num;
        }
        ans*=recur(n-last);
        System.out.println(ans);
    }
}

