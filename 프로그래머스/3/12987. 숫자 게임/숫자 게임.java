import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int left = 0;
        int right = 0;
        while (right < B.length) {
            if(A[left] < B[right]){
                answer++;
                right++;
                left++;
            }else{
                right++;
            }
        }
        return answer;
    }
}