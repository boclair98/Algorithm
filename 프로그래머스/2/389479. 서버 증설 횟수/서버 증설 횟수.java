import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int n = players.length;
        Queue<Integer> time = new ArrayDeque<>();
        
        
        for(int i = 0; i<n; i++){
            Iterator<Integer> iter = time.iterator();
            while (iter.hasNext()) {
                int val = iter.next();
                if (val <= i) {
                    iter.remove(); 
                }
            }
            int number = players[i] / m ;
            int serverSize = time.size();
            int needSize = number - serverSize;
            for(int j = 0; j<needSize; j++){
                time.offer(i+k);
                answer++;
            }
            System.out.println(time+" "+answer);
            
        }
        
        return answer;
    }
    
    
}