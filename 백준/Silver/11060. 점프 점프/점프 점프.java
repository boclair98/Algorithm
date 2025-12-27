import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[] arr = new int[1050];
    static int[] dp = new int[1050];
    static int recur(int idx){
        if(idx >= n) return 1000000000;
        if (idx == n-1) return 0;
        if(dp[idx] != -1) return dp[idx];
        int cnt = 0;
        int res = arr[idx];
        int min = 1000000000;
        for(int i = 1; i<= res; i++){
            cnt = recur(idx+i);
            if(cnt != 1000000000){
                min = Math.min(min, cnt+1);
            }
        }
        return dp[idx] = min;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, -1);
        int result = recur(0);
        if(result == 1000000000){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }
}

