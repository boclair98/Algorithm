import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n;
    static int[] dp = new int[50050];
    static int recur(int num){
        if(num <= 2) return 1;
        if(num == 3) return 2;
        if(dp[num] != -1) return dp[num];
        return dp[num] = (recur(num-1) + recur(num-3)) % 1000000009;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Arrays.fill(dp,-1);
        System.out.println(recur(n));
    }
}