import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int MOD = 1000000000;
    static int[] dp = new int[1000010];
    static int recur(int num){
        if(num == 0) return 0;
        if(num == 1 || num == 2) return 1;
        if(dp[num] != -1) return dp[num];
        return dp[num] = (recur(num-1) % MOD)+(recur(num-2)%MOD) % MOD;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Arrays.fill(dp, -1);
        if(n == 0){
            System.out.println(0);
        }else if(n > 0){
            System.out.println(1);
        }else{
            n = -n;
            if(n % 2 == 1){
                System.out.println(1);
            }else{
                System.out.println(-1);
            }
        }
        System.out.println(recur(n) % MOD);

    }
}

