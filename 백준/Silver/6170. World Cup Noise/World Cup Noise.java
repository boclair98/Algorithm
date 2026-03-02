import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n,t;
    static int[][]dp;
    static int recur(int idx, int prev){
        if(idx == t) return 1;
        if(dp[idx][prev] != -1) return dp[idx][prev];
        int ans = recur(idx+1,0);
        if(prev!=1){
            ans+=recur(idx+1,1);
        }
        return dp[idx][prev] = ans;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int cnt = 1;
        while(n -- > 0){
            dp = new int[100][2];
            for(int i = 0; i < 100; i++){
                Arrays.fill(dp[i],-1);
            }
            t = Integer.parseInt(br.readLine());
            System.out.println("Scenario #"+cnt+":");
            System.out.println(recur(0,0));
            System.out.println();
            cnt++;
        }
    }
}