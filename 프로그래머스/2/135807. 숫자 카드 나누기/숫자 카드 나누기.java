class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int n = arrayA.length;

        // 철수, 영희 카드의 최대공약수 구하기
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for (int i = 1; i < n; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        boolean Acheck = true;
        boolean Bcheck = true;
        
        //철수 상태 확인
        //영희걸로 나누어 떨어지면 false
        for(int i = 0; i<n; i++){
            if(arrayA[i] % gcdB == 0){
                Bcheck = false;
                break;
            }
        }
        
        //영희 상태 확인
        //철수걸로 나누어 떨어지면 false
        for(int i = 0; i<n; i++){
            if(arrayB[i] % gcdA == 0){
                Acheck = false;
                break;
            }
        }
        
        if(Acheck){
            answer = Math.max(answer,gcdA);
        }
        if(Bcheck){
            answer = Math.max(answer,gcdB);
        }
        

        return answer;
    }

    // 최대공약수 (유클리드 호제법)
    private static int gcd(int a, int b) {
        int temp;
        while (b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
