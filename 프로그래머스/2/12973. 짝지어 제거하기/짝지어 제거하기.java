import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        
        for(char m: s.toCharArray()){
            if(stack.size() == 0){
                stack.add(m);
            }else if(stack.get(stack.size()-1) != m){
                stack.add(m);
            }else{
                stack.pop();
            }
            
        }
        if(stack.size() == 0){
            answer = 1;
        }

        return answer;
    }
}