class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int num1 = (numer1 * denom2) + (denom1 * numer2);
        int num2 = (denom1 * denom2);
        int gc = gcd(num1,num2);
        answer[0] = num1 / gc;
        answer[1] = num2 / gc;
        return answer;
    }
    private static int gcd(int a, int b){   
        int ans = 0;
        while(b!=0){
            ans = a % b;
            a = b;
            b = ans;
        }
        return a;
    }
}