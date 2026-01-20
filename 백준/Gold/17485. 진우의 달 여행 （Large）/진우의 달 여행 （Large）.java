import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;
    static int[][] arr;
    static int[][][] dp = new int[1010][1010][5];
    static int recur(int idx, int col, int prev){
        if(idx == n) return 0;
        if(dp[idx][col][prev] != -1) return dp[idx][col][prev];
        int res = 1000000000;
        for(int i = 0; i < 3; i++){
            if(i == prev) continue;
            int next_col = col + (i-1);
            if(next_col < 0 || next_col >=m) continue;
            res = Math.min(res,recur(idx+1,next_col,i) + arr[idx][col]);
        }
        return dp[idx][col][prev] = res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < 1010; i++){
            for(int j = 0; j < 1010; j++){
                for(int k = 0; k < 5; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            answer = Math.min(answer,recur(0,i,3));
        }
        System.out.println(answer);

    }
}