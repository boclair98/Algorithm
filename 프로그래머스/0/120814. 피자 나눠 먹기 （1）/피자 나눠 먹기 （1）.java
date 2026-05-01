class Solution {
    public int solution(int n) {
        int answer = n / 7;
        int next = n - (answer * 7);
        if(next > 0) answer++;
        return answer;
    }
}