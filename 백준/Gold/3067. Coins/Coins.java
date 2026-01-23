import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int t,n, goal_coin;
    static int[] arr;
    static int[][] dp = new int[25][100000];
    static int recur(int idx, int coin){
        if(coin > goal_coin) return 0;
        if(coin == goal_coin) return 1;
        if(idx == n) return 0;
        if(dp[idx][coin] != -1) return dp[idx][coin];
        int ans = 0;
        ans += recur(idx,coin+arr[idx]);
        ans += recur(idx+1,coin);
        return dp[idx][coin] = ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while(t -- > 0){
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            goal_coin = Integer.parseInt(br.readLine());
            for(int i = 0; i < 25; i++){
                Arrays.fill(dp[i],-1);
            }
            System.out.println(recur(0,0));
        }

    }
}