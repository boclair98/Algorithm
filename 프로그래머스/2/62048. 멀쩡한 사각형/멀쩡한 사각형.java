class Solution {
    static int[] dx ={0,1,1,2};
    static int[] dy ={0,0,1,1};
    public long solution(long w, long h) {
        long answer  = w*h;
        long mul = gcd(w,h); //4
        w = w / mul; //2
        h = h / mul; //3
        
        return answer - (mul * (w+h - 1));
    }
    
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
    return a;
    }

}