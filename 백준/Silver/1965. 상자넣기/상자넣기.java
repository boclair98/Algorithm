import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[] arr = new int[1010];
    static int[] dp = new int[1010];
    static int recur(int idx){
        if(idx == n) return 1;
        if(dp[idx] != -1) return dp[idx];
        dp[idx] = 1;
        for(int i = idx+1; i < n; i++){
            if(arr[idx] < arr[i]){
                dp[idx] = Math.max(recur(i)+1, dp[idx]);
            }
        }
        return dp[idx];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, -1);
        int c = 0;
        for(int i = 0; i < n; i++){
            c = Math.max(recur(i), c);
        }
        System.out.println(c);
    }
}

