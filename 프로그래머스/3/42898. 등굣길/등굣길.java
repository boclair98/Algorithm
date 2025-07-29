import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[101][101];
        boolean[][] visited = new boolean[101][101];
        dp[1][1] = 1;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(i == 1 && j == 1) continue;
                boolean check = true;
                for(int k = 0; k<puddles.length; k++){
                    if(i == puddles[k][1] && j == puddles[k][0]){
                        dp[i][j] = 0;
                        check = false;
                        break;
                        
                    }
                }
                if(!check) continue;
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
                // if(check){
                //     if(i == 1){
                //         dp[i][j] = 1 % 1000000007;
                //     }else if(j == 1){
                //         dp[i][j] = 1% 1000000007;
                //     }else{
                //         dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
                //     }
                    // System.out.println(dp[i][j]);
                }
            }
        return dp[n][m];
    }
}