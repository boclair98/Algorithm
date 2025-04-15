import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0; i<s.length(); i++){
            deque.offer(s.charAt(i));
        }
        int idx = 0;
        int last = s.length();
        int num = 0;
        while (idx < last){
            Stack<Character> stack = new Stack<>();
            while (num < idx){
                num++;
                deque.offer(deque.pollFirst());
            }
            
            idx++;
            List<Character> list = new ArrayList<>(deque);
            for(int i = 0; i< list.size(); i++){
                if(list.get(i) ==')'|| list.get(i)==']'|| list.get(i)=='}'){
                    if(stack.isEmpty()){
                        stack.add(list.get(i));
                        break;
                    }
                }
                if(list.get(i)=='('||list.get(i)=='['||list.get(i)=='{'){
                    stack.add(list.get(i));
                }else if(list.get(i) == ')'){
                    if(!stack.isEmpty()&&stack.get(stack.size()-1) =='('){
                        stack.pop();
                    }
                }else if(list.get(i) == ']'){
                    if(!stack.isEmpty()&&stack.get(stack.size()-1) =='['){
                        stack.pop();
                    }
                }else if(list.get(i) == '}'){
                    if(!stack.isEmpty()&&stack.get(stack.size()-1) =='{'){
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}