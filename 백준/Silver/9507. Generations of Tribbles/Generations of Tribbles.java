import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n;
    static int[][] arr;
    static long[] dp;
    static long recur(int idx){
        if(idx < 2) return 1;
        if(idx == 2) return 2;
        if(idx == 3) return 4;
        if(dp[idx] != -1) return dp[idx];
        return  dp[idx] = recur(idx-1) + recur(idx-2) + recur(idx-3) + recur(idx-4);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[100000];
        Arrays.fill(dp,-1);
        while(n-->0){
            System.out.println(recur(Integer.parseInt(br.readLine())));
        }
    }
}