import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[] dp = new int[100001];
    static int recur(int idx){
        if(idx < 0) return 0;
        if(idx == 0) return 0;
        if(dp[idx] != -1) return dp[idx];
        int res = 10000000;
        for(int i = 1; i*i<=idx; i++){
            res = Math.min(res,recur(idx - (i*i))+1);
        }
        return dp[idx] = res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Arrays.fill(dp, -1);
        System.out.println(recur(n));
    }
}

