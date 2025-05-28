import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {
    static int[][] map ;
    static int[][] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        StringTokenizer st ;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<i+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(DP(0,0));
    }
    static int DP(int idx, int start){
        if(idx == n-1){
            return map[idx][start];
        }
        if(dp[idx][start]!=-1){
            return dp[idx][start];
        }

        dp[idx][start] = Math.max(DP(idx+1,start),DP(idx+1,start+1)) + map[idx][start];
        return dp[idx][start];
    }
}