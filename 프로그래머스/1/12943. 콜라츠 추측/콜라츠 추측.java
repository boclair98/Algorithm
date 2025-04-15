class Solution {
    public int solution(long num) {
        int answer = 0;
        int count = 0;
        while (true){
            if(num == 1){
                break;
            }
            if(num % 2 == 0){
                num = num / 2;
                answer++;
            }else{
                num = num * 3 + 1;
                answer++;
            }
        }
        if(answer > 500){
            return -1;
        }
        return answer;
    }
}