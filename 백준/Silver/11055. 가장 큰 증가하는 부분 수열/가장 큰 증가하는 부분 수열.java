import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[] arr;
    static int[] dp;
    static int max_val = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        dp = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        for(int i = 0; i<n; i++){
            dp[i] = arr[i];
            for(int j = 0; j<i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+arr[i]);
                }
            }
            max_val = Math.max(max_val,dp[i]);
        }
        System.out.println(max_val);
    }
}
