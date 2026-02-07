import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n;
    static int[][] arr = new int[20][2];
    static int[] dp = new int[20];
    static int recur(int idx){
        if(idx == n) return 0;
        if(idx > n) return Integer.MAX_VALUE;
        if(dp[idx] != -1) return dp[idx];
        int ans = recur(idx+1);
        ans = Math.max(ans,recur(idx+arr[idx][0])+arr[idx][1]);
        return dp[idx] = ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,-1);
        System.out.println(recur(0));
    }
}