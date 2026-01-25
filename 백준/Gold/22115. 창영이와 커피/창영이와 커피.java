import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n,k;
    static int[] arr = new int[105];
    static long[][] dp = new long[105][100005];
    static long recur(int idx, int cof){
        if(cof > k) return Integer.MAX_VALUE;
        if(cof == k) return 0;
        if(idx == n) return Integer.MAX_VALUE;
        if(dp[idx][cof] != -1) return dp[idx][cof];
        long ans = 0;
        ans = recur(idx+1,cof+arr[idx]) + 1;
        ans = Math.min(ans,recur(idx+1,cof));
        return dp[idx][cof] = ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < 105; i++){
            Arrays.fill(dp[i],-1);
        }
        long answer = recur(0,0);
        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }
}