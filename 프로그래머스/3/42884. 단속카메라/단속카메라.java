import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 끝나는 지점 기준 오름차순 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int camera = Integer.MIN_VALUE;

        for (int[] route : routes) {
            // 현재 카메라가 이 차량의 구간에 포함되지 않으면 새 카메라 설치
            if (camera < route[0]) {
                camera = route[1];
                answer++;
            }
        }

        return answer;
    }
}
