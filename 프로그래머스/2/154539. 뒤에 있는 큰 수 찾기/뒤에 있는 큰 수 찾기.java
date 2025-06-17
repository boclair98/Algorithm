import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        
        int idx = 0; 
        int last = numbers.length;
        int[] answer = new int[last];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<last; i++){
            
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        for(int i = 0; i<last; i++){
            if(answer[i] == 0){
                answer[i] = -1;
            }
        }
        
        
        
        return answer;
    }
}