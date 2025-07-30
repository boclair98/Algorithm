import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[101][101];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // dfs(1,1,n,m,puddles,dp);
        return dfs(1,1,n,m,puddles,dp);
    }
    
    public static int dfs(int x, int y, int n, int m ,int[][] puddles, int[][] dp){
        if(x > n || y > m){
            return 0;
        }
        
        if(x == n && y == m) {
            return 1;
        }
        
        //기존에 들렸던 기억이 있다면 재활용.
        if(dp[x][y] != -1){
            return dp[x][y] ;
        }
        
        //물에 잠기면 0 반환
        for(int i = 0; i<puddles.length; i++){
            if(x == puddles[i][1] && puddles[i][0] == y) return 0;
        }
        
        return dp[x][y] = (dfs(x+1,y,n,m,puddles,dp) + dfs(x,y+1,n,m,puddles,dp))  % 1000000007 ;
    }
}