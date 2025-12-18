import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[] dp = new int[5050];
    static int recur(int idx){
        if(idx < 0) return 1;
        if(idx == 0) return 0;
        if(dp[idx] != -1) return dp[idx];
        if(recur(idx - 1) == 0 || recur(idx - 3) == 0){
            return dp[idx] = 1;
        }else{
            return dp[idx] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i <= n; i++){
            dp[i] = -1;
        }
        if(recur(n) == 1){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}

