import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        // int 대신 long 타입을 사용하여 오버플로우 방지
        long total = 0;
        long sum1 = 0;
        
        // 1. 조건식을 q1.size()에서 queue1.length로 변경
        for(int i = 0 ; i < queue1.length; i++){
            total += (queue1[i] + queue2[i]);
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1 += queue1[i];
        }
        
        if(total % 2 == 1) return -1;
        long goal = total / 2;
        
        // 두 큐의 원소가 한 바퀴 반 이상 돌 때까지 답을 못 찾으면 불가능한 경우임
        int limit = (queue1.length + queue2.length) * 2;
        
        while(true){
            if(answer > limit) return -1;
            if(goal == sum1) break;
            
            if(sum1 > goal){
                int val = q1.poll();
                sum1 -= val;
                q2.add(val);
            } else {
                int val = q2.poll();
                sum1 += val;
                q1.add(val);
            }
            answer++;
        }
        return answer;
    }
}
