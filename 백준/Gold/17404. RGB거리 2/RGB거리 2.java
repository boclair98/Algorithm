import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[][] arr = new int[1010][3];
    static int[][][] dp = new int[1010][3][3];
    static int recur(int idx, int start, int now){
        if(idx == n) return 0;
        if(dp[idx][start][now] != -1) return dp[idx][start][now];
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < 3; i++){
            if(i == now) continue;
            if(idx == n-1 && i == start) continue;
            ans = Math.min(ans, recur(idx+1, start, i) + arr[idx][i]);
        }
        return dp[idx][start][now] = ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < 1010; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        int min_val = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            min_val = Math.min(min_val,recur(1,i,i) + arr[0][i]);
        }
        System.out.println(min_val);

    }
}
