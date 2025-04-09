import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
		Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char word = s.charAt(i);
            if(word =='('){
                stack.add(word);
            }else{
                if(stack.size() == 0){
            
                    stack.add(word);
                    break;
                }else{
                    if(stack.get(stack.size()-1) == '('){
                        stack.pop();
                    }
                }
            }
        }
        if(stack.size() > 0){
            answer = false;
        }
        

        return answer;
    }
}