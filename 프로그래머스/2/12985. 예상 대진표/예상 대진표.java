class Solution {
    public int solution(int n, int A, int B) {
        int round = 0;

        while (A != B) {
            A = (A + 1) / 2;
            B = (B + 1) / 2;
            round++;
        }

        return round;
    }
}
