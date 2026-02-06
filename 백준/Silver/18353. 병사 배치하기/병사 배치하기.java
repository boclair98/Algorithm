import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[] arr = new int[2005];
    static int[][] dp = new int[2005][2005];
    static int recur(int idx, int prev){
        if(idx == n) return 0;
        if(dp[idx][prev] != -1) return dp[idx][prev];
        int ans = recur(idx+1, prev);
        if(prev == n || arr[idx] < arr[prev]){
            ans = Math.max(ans,recur(idx+1, idx) + 1);
        }
        return dp[idx][prev] = ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < 2005; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(n-recur(0,n));

    }
}
