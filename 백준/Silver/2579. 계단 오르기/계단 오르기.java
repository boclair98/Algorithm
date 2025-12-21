import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[] arr = new int[3050];
    static int[][] dp = new int[3050][5];
    static int max_val = 0;
    static int recur(int idx, int count){
        if(idx >= n) return -1000000000;
        if(idx == n-1) return arr[idx];
//        if(idx == n-1) return arr[idx];
        if(dp[idx][count] != -1) return dp[idx][count];
        int a = 0;
        if(count < 2){
            a = recur(idx+1,count+1) + arr[idx];
        }
        int b = recur(idx+2,1) + arr[idx];
        return dp[idx][count] = Math.max(a,b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i<3050; i++){
            Arrays.fill(dp[i],-1);
        }
        int a = recur(0,1);
        int b = recur(1,1);
        System.out.println(Math.max(a,b));

    }
}