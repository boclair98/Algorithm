import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[][] dp = new int[100010][3];
    static int recur(int idx, int num) {
        if(idx == n) return 1;
        if(dp[idx][num] != -1) return dp[idx][num];
        int ans = 0;
        ans+=recur(idx + 1, 0);
        if(num != 1){
            ans+=recur(idx + 1, 1);
        }
        if(num != 2){
            ans+=recur(idx + 1, 2);
        }
        return dp[idx][num] = ans % 9901;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < 100010; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recur(0, 0));
    }
}
