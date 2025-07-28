import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<works.length; i++){
            pq.offer(works[i]);
        }
        while(n > 0){
            int num = pq.poll();
            if(num > 0){
                num --;
            }
            n -- ;
            pq.offer(num);
        }
        while(!pq.isEmpty()){
            answer+=Math.pow(pq.poll(),2);
        }
//         List<Integer>list = new ArrayList<>();
//         Queue<Integer> q = new ArrayDeque<>();
//         for(int i = 0; i<works.length; i++){
//             list.add(works[i]);
//         }
//         Collections.sort(list,Collections.reverseOrder());
        
//         while(n > 0){
//             int num = list.remove(0);
//             if(num > 0){
//                 num--;   
//             }
//             n--;
//             list.add(num);
//             Collections.sort(list,Collections.reverseOrder());
//         }
//         for(int i = 0; i<list.size(); i++){
//             answer+=(Math.pow(list.get(i),2));
//         }
        
        return answer;
    }
}