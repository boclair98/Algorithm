import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[][] arr = new int[15][2];
    static int[] dp = new int[200];
    static int recur(int cur){
        if(cur > n) return -1000000000;
        if(cur == n) return 0;
        if(dp[cur] !=-1) return dp[cur];
        int a = recur(cur+arr[cur][0]) + arr[cur][1];
        int b = recur(cur+1);
        return dp[cur] = Math.max(a,b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, -1);
        System.out.println(recur(0));
    }
}

