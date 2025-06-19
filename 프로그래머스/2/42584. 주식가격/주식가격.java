import java.util.*;
class Solution {
    public List<Integer> solution(int[] prices) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i<prices.length; i++){
            int count = 0;
            boolean check = false;
            for(int j = i+1; j<prices.length; j++){
                count++;
                if(prices[i] > prices[j]){
                    break;
                }
            }
            answer.add(count);
        }
        return answer;
    }
}