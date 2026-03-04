import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,t;
    static int[][] walk = new int[100][2];
    static int[][] bike = new int[100][2];
    static int[][] dp = new int[101][100050];
    static int recur(int idx, int total){
        if(total>t) return -1_000_000_000;
        if(idx == n) return 0;
        if(dp[idx][total] != -1) return dp[idx][total];
        int ans = 0;
        ans = recur(idx+1,total+walk[idx][0]) + walk[idx][1];
//        ans = Math.max(ans,recur(idx+1,total+walk[idx][0]) + walk[idx][1]);
        ans = Math.max(ans,recur(idx+1,total+bike[idx][0]) + bike[idx][1]);
        return dp[idx][total] = ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                walk[i][j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 0; j < 2; j++){
                bike[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i <100; i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(recur(0,0));
    }
}