import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int t,n, money;
    static int[] arr;
    static int[][] dp;
    static int recur(int idx, int total){
        if(idx == n) return 0;
        if(total > money) return 0;
        if(total == money) return 1;
        if(dp[idx][total] != -1) return dp[idx][total];
        int ans = recur(idx,total+arr[idx]);
        int ans2 = recur(idx+1,total);
        return dp[idx][total] = ans2 + ans;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dp = new int[25][200050];
            money = Integer.parseInt(br.readLine());
            for(int i = 0; i < 25; i++){
                Arrays.fill(dp[i],-1);

            }
            System.out.println(recur(0,0));
        }
    }
}