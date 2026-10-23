class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int word = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int num = 2 * a * b;
        if(word > num){
            answer = word;
        }else{
            answer = num;
        }
        return answer;
    }
}