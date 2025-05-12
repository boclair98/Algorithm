import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer,Integer> c = new HashMap<>();
        Map<Integer,Integer> d = new HashMap<>();
        for(int t : topping){
            c.put(t,c.getOrDefault(t,0)+1);
        }
        for(int t : topping){
            d.put(t,d.getOrDefault(t,0)+1);
            c.put(t,c.get(t)-1);
            if(c.get(t) == 0){
                c.remove(t);
            }
            if(d.size() == c.size()){
                answer++;
            }
        }
        
        return answer;
    }
}
