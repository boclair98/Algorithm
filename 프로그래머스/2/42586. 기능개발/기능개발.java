import java.util.*;
class Solution {
    static Deque<Integer> dq1 = new ArrayDeque<>();
    static Deque<Integer> dq2 = new ArrayDeque<>();
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++){
            dq1.add(progresses[i]);
            dq2.add(speeds[i]);
        }
        
        while(!dq1.isEmpty()){
            int cnt = 0;
            int size = dq1.size();
            for(int i = 0; i < size; i++){
                int prog = dq1.poll();
                int speed = dq2.poll();
                dq1.add(prog+speed);
                dq2.add(speed);
            }
            int idx = 0;
            while(true){
                if(!dq1.isEmpty() && dq1.peek() >= 100){
                    dq1.poll();
                    dq2.poll();
                    cnt++;
                }else{
                    break;
                }
            }
            if(cnt > 0) {
                answer.add(cnt);
            }
          
        }
        
        return answer;
    }
}