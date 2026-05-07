import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int max_number = 0;
        for(int i = 0; i < order.length; i++){
            max_number = Math.max(max_number,order[i]);
        }
        
        //줘야 할 상자
        Deque<Integer> box = new ArrayDeque<>();
        for(int i = 1; i <= max_number ; i++){
            box.add(i);
        }
        
        //보조컨테이너
        int idx = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < max_number; i++){
            if(order[idx] == box.peek()){
                answer++;
                idx++;
                box.poll();
                break;
            }else if(!box.isEmpty()){
                dq.addFirst(box.poll());
                
            }
        }

                
        while(idx < order.length){
            boolean flag= false;
            if(!dq.isEmpty() && order[idx] == dq.peek()){
                idx++;
                answer++;
                dq.poll();
                flag= true;
            }
            else if(!box.isEmpty() && order[idx] == box.peek()){
                box.poll();
                idx++;
                answer++;
                flag= true;
            }
            else if(!box.isEmpty()){
                dq.addFirst(box.poll());
                continue;
            }
            if(!flag) break;
        }
        return answer;
    }
}