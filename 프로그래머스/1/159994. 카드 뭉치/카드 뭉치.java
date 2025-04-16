import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int count = 0;
        Deque<String> deque1 = new ArrayDeque<>();
        Deque<String> deque2 = new ArrayDeque<>();
        for(int i = 0; i<cards1.length; i++){
            deque1.addLast(cards1[i]);
        }
        System.out.println(deque1);
        for(int i = 0; i<cards2.length; i++){
            deque2.addLast(cards2[i]);
        }
        System.out.println(deque2);
        for(int i = 0; i<goal.length; i++){
            if(!deque1.isEmpty() && deque1.getFirst().equals(goal[i])  ){
                deque1.removeFirst();
                count++;
            }else if(!deque2.isEmpty() && deque2.getFirst().equals(goal[i]) ){
                deque2.removeFirst();
                count++;
            }
        }
        if(count == goal.length){
            answer = "Yes";
        }else{
            answer ="No";
        }
        return answer;
    }
}