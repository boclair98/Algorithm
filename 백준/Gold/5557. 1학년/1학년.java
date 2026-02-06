import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[] arr = new int[110];
    static long[][] dp = new long[110][110];
    static long recur(int idx, int total){
        if(total > 20 || total < 0) return 0;
        if(idx == n-1){
            if(total == arr[n-1]) return 1;
            else return 0;
        }
        if(dp[idx][total] != -1) return dp[idx][total];
        long ans = 0;
        ans+=recur(idx+1, total+arr[idx]);
        ans+=recur(idx+1, total-arr[idx]);
        return dp[idx][total] = ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 110; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recur(1, arr[0]));

    }

}
