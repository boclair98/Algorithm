class Solution {
    public int solution(int n) {
        int answer = 0 ;
        int count = Integer.bitCount(n);
        // System.out.println(count);
        
        while (true){
            n++;
            int cnt = Integer.bitCount(n);
            if(cnt == count){
                answer = n;
                break;
            }
        }
        
        return answer;
        
    }
}