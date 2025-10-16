import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1,o2) ->{
            return Integer.compare(o1[1],o2[1]);
        });
        // for(int i = 0; i<routes.length; i++){
        //     System.out.println(routes[i][0] +" " + routes[i][1]);
        // }
        int prev = -Integer.MAX_VALUE;
        for(int i = 0; i<routes.length; i++){
            int start =routes[i][0];
            int end =routes[i][1];
            if(prev < start){
                prev = end;
                answer++;
            }
        }
        return answer;
    }
}