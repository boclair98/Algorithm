import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<int[]> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
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