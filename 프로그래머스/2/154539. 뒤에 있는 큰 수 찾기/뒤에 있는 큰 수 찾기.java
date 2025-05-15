import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n];
        for(int i = 0; i<numbers.length; i++){
            
            while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
            
        }
        for(int i = 0; i<n; i++){
            if(answer[i] == 0){
                answer[i] = -1;
            }
        }
        
        
        
        return answer;
    }
}