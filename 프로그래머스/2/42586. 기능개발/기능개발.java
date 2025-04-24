import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int n = speeds.length;
        for(int i = 0; i<n; i++){
            if((100-progresses[i]) % speeds[i] == 0){
                q.offer((100 - progresses[i]) / speeds[i]);
            }else{
                q.offer((100-progresses[i]) / speeds[i] + 1);
            }
        }
        
        int day = 1;
        int now = q.poll();
        // System.out.println(now);
        // System.out.println(q);
        while (!q.isEmpty()){
            if(now>=q.peek()){
                day++;
                q.poll();
            }else{
                list.add(day);
                now = q.poll();
                day = 1;
            }
        }
        list.add(day);
        return list;
    }
}