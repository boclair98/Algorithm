import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        //기존 우선순위
        Deque<int[]> q1 = new ArrayDeque<>();
        //MAX값 
        Deque<Integer> q2 = new ArrayDeque<>();
        //방문 여부 판단하기위함 visited
        //처음 location을 방문한 곳으로 판단.
        boolean[] visited = new boolean[101];
        
        for(int i = 0; i<priorities.length; i++){
            q1.add(new int[]{priorities[i],i});
            q2.add(priorities[i]);
        }
        visited[location] = true;
        while (true){
            int[] cur = q1.poll();
            int number = cur[0];
            int vist = cur[1];
            int check = q2.peek();
            if(check == Collections.max(q2)){
                answer++;
                q2.poll();
                if(visited[vist]){
                    break;
                } 
            }else{
                q2.add(q2.poll());
                q1.add(new int[]{number,vist});
            }
        }
        
        return answer;
    }
}