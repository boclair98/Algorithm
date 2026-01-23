import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int c,n;
    static int[][] arr = new int[25][2];
    static int[][] dp = new int[25][1050];
    static int recur(int idx, int human){
        if(idx == n) return 1000000000;
        if(human >= c) return 0;
        if(dp[idx][human] != -1) return dp[idx][human];
        int ans = 1000000000;
        ans = Math.min(ans,recur(idx,human+arr[idx][1]) + arr[idx][0]);
        ans = Math.min(ans,recur(idx+1,human));
        return dp[idx][human] = ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<25; i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(recur(0,0));
    }
}