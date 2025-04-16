class Solution {
    public long solution(int a, int b, int n) {
        long answer = 0;
        while (n>=a){
            answer = answer + (n/a * b);
            n = n / a * b  + n % a;
            System.out.println(n);
            System.out.println(answer);
        }
        
        return answer;
        
    }
}