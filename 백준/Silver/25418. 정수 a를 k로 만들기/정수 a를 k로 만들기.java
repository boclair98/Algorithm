import javax.imageio.ImageTranscoder;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m;
    static int[] dp;
    static int recur(int idx){
        if(idx < n) return 999999999;
        if(idx == n) return 0;
        if(dp[idx] != -1) return dp[idx];
        int ans = 999999999;
        if(idx % 2 == 0 && idx / 2 >=n){
            ans = Math.min(ans,recur(idx / 2) + 1);
        }else{
            ans = Math.min(ans,recur(idx-1)+1);
        }
        return dp[idx] = ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[m+1];
        Arrays.fill(dp,-1);
        System.out.println(recur(m));
    }
}
