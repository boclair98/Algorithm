import java.util.*;
class Solution {
    static int total = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length];
        
        DFS(0,answer,numbers,target,visited);
        
        return total;
    }
    static void DFS(int idx, int answer, int[] numbers, int target, boolean[] visited){
        if(idx == numbers.length){
            if(answer == target){
                total++;
            }
            return;
        }
        DFS(idx+1,answer+numbers[idx],numbers,target,visited);
        DFS(idx+1,answer-numbers[idx],numbers,target,visited);
    }
}