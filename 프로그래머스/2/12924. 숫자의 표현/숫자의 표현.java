class Solution {
    public int solution(int n) {
        int idx = 1;
        int total = 0;
        while(idx<=n){
            int sum = 0;
            for(int i =idx; i<=n; i++){
                sum+=i;
                if(sum == n){
                    total++;
                }
                if(sum > n){
                    break;
                }
            }
            idx++;
        }
        return total;
    }
}