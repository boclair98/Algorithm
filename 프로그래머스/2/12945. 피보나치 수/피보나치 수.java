class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[1000001];
        dp[1] = 1;
        
        for(int i = 2; i<1000001; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        return dp[n];
    }
}