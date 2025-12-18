import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[][] map;
    static int[][] dp;
    static int min_val = Integer.MAX_VALUE;
    static int recur(int x,int prev){
        if(x == n){
            return 0;
        }
        if(dp[x][prev]!=-1){
            return dp[x][prev];
        }
        int a = 1000000000;
        for(int i = 0; i<3; i++){
            if(i == prev) continue;
            a = Math.min(recur(x+1,i)+map[x][i],a);
        }
        return dp[x][prev] = a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][4];
        dp = new int[n+1][4];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<4; j++){
                dp[i][j] = -1;
            }
        }
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(recur(0,3));
    }
}