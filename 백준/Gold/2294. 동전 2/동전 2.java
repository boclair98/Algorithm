import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, k, count;
    static int[] arr = new int[110];
    static int[] dp = new int[10050];
    static int recur(int money){
        if(money == 0) return 0;
        if(money < 0) return 1000000000;
        if(dp[money] != -1) return dp[money];
        int ans = 1000000000;
        for(int i = 0 ; i < n; i++){
            ans = Math.min(ans,recur(money - arr[i])+1);
        }
        return dp[money] = ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp,-1);
        int answer = recur(k);
        if(answer == 1000000000){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }
}