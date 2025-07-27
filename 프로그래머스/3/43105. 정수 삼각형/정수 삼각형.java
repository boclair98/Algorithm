import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] dp = new int[501][501];
        dp[0][0] = triangle[0][0];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                dp[i][j] = Math.max(dp[i-1][j]+triangle[i][j], dp[i][j]);
                dp[i][j+1] = Math.max(dp[i-1][j] +triangle[i][j+1],dp[i][j+1]);
                answer = Math.max(answer,Math.max(dp[i][j],dp[i][j+1]));
            }    
        }
        return answer;
    }
}