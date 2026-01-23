import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m, money;
    static int[][] arr = new int[1100][2];
    static int[][]dp = new int[1100][1010];
    static int recur(int idx, int today){
        if(today == 0) return 0;
        if(today < 0 ) return -1000000000;
        if(idx == n) return 0;
        if(dp[idx][today] != -1) return dp[idx][today];
        int ans = 0;
        ans = Math.max(ans,recur(idx+1,today - arr[idx][0]) + arr[idx][1]);
        ans = Math.max(ans,recur(idx+1,today));
        return dp[idx][today] = ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            money+=arr[i][1];
        }
        for(int i = 0; i < 1100; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(money - recur(0, m));


    }
}
