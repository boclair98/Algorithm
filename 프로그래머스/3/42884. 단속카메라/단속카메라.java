import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        //카메라 갯수
        int answer = 0;
        
        //카메라 설정
        int camera = -Integer.MAX_VALUE;
        
        // System.out.println(camera);
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int n = routes.length;
        // [[-20,-15],  [-18,-13], [-14,-5], [-5,-3]]
        // -15 -5
        for(int i = 0; i<n; i++){
            // System.out.println(routes[i][0]+" "+routes[i][1]);
            int start = routes[i][0];
            int end = routes[i][1];
            if(camera < start){
                answer++;
                camera = end;
            }
        }
        return answer;
    }
}