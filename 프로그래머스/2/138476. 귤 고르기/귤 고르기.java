import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();        
        for(int i = 0; i<tangerine.length; i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        // System.out.println(map);
        List<Integer> count = new ArrayList<>(map.values());
        Collections.sort(count,Collections.reverseOrder());
        
        for(Integer m: count){
            k-=m;
            answer++;
            if(k<=0){
                break;
            }
        }
        return answer;
    }
}