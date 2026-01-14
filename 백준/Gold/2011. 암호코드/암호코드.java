import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static String n;
    static int[] dp;
    static int recur(int idx){
        if(idx == n.length()) return 1;
        if(dp[idx] != -1) return dp[idx];
        if(n.charAt(idx) == '0') return 0;
        int res = recur(idx+1) % 1000000;
        if(idx + 1 < n.length()){
            int num = Integer.parseInt(n.substring(idx,idx+2));
            if(num >= 10 && num <=26){
                res = (res + recur(idx+2)) % 1000000;
            }
        }
        return dp[idx] = res;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();
        dp = new int[n.length()];
        Arrays.fill(dp, -1);
        int ans = recur(0);
        if(ans <=0){
            System.out.println(0);
        }else{
            System.out.println(ans);
        }
    }
}
