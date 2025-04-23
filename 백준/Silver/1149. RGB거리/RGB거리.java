import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] rgb = new int[n][n];
        int[][] dp = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i<3; i++){
            dp[0][i] = rgb[0][i];
        }
        for(int i =1; i<n; i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + rgb[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + rgb[i][1];
            dp[i][2] = Math.min(dp[i-1][1],dp[i-1][0]) + rgb[i][2];
        }
        int min_value = Integer.MAX_VALUE;
        for(int i = 0; i<3; i++){
            min_value = Math.min(min_value,dp[n-1][i]);
        }
        System.out.println(min_value);


    }
}