import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[] arr;
    static int[][] dp;
    static int recur(int idx, int cnt){
        if(idx == n){
            return 0;
        }
        if(dp[idx][cnt]!=-1){
            return dp[idx][cnt];
        }
        int a = 0;
        a = recur(idx+1,0);
        if(cnt < 2){
            a = Math.max(a,recur(idx+1,cnt+1)+arr[idx]);
        }
        return dp[idx][cnt] = a ;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n][3];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            Arrays.fill(dp[i],-1);
        }
        System.out.println(recur(0,0));
    }
}