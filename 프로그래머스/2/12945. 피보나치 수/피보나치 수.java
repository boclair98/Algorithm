import java.util.*;
class Solution {
    static int[] memo = new int[1000001];
    static int fibo(int num){
        if(num == 0) return 0;
        if(num <= 2) return 1;
        if(memo[num]!=-1) return memo[num];
        
        return memo[num] = (fibo(num-2) + fibo(num-1))%1234567;
    }
    public int solution(int n) {
        int answer = 0;
        
        Arrays.fill(memo,-1);
        
        return fibo(n);
    }
}