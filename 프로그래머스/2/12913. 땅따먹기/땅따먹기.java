import java.util.*;
class Solution {
    static int n,m;
    static int[][] dp;
    static int[][] staticLand;
    static int recur(int idx,int s){
        if(idx == n) return 0;
        if(s!=-1 && dp[idx][s]!= -1) return dp[idx][s];
        int ans = 0;
        for(int i = 0; i < 4; i++){
            if(s == i) continue;
            ans = Math.max(ans, recur(idx+1,i)+staticLand[idx][i]);
        }
        if(s!= -1){
            dp[idx][s] = ans;
        }
        return ans;
    }
    int solution(int[][] land) {
        int answer = 0;
        staticLand = land;
        n = land.length;
        m = land[0].length;
        dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }
        return recur(0,-1);
    }
}