import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        // 끝나는 시간 기준으로 정렬
        Arrays.sort(targets, (a,b) -> Integer.compare(a[1], b[1]));

        int last = -1; // 마지막 요격 위치
        for(int i = 0; i < targets.length; i++){
            int start = targets[i][0];
            int end = targets[i][1];
            if(start >= last){
                // 요격 필요
                answer++;
                last = end; // 레이저 위치 갱신
            }
        }
        return answer;
    }
}
