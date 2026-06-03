import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int cnt = 0;
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            q.add(s.charAt(i));
        }
        for(int i = 0; i < s.length(); i++){
            q.add(q.poll());
            if(check(q)) answer++;
        }
        return answer;
    }
    private boolean check(Queue<Character> q){
        Stack<Character> stack = new Stack<>();
        for(char s : q){
            if(s =='(' || s == '[' || s =='{'){
                stack.push(s);
            }else{
                if(stack.isEmpty()) return false;
                if(s == ')'){
                    if(stack.get(stack.size()-1) == '('){
                        stack.pop();
                    }
                }
                if(s == ']'){
                    if(stack.get(stack.size()-1) == '['){
                        stack.pop();
                    }
                }
                if(s == '}'){
                    if(stack.get(stack.size()-1) == '{'){
                        stack.pop();
                    }
                }
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}