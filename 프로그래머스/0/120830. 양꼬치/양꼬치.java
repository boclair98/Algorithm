class Solution {
    public int solution(int n, int k) {
        int answer = n / 10;
        k = k - answer;
        return n * 12000 + k * 2000;
    }
}