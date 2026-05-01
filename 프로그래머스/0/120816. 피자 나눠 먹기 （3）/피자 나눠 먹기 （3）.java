class Solution {
    public int solution(int slice, int n) {
        int answer = n / slice;
        int next = n % slice;
        if(next > 0) answer++;
        return answer;
    }
}