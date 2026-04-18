import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);
        return answer;
    }
    public static void dfs(int[] numbers, int target ,int total,int idx){
        if(idx == numbers.length){
            if(total == target){
                answer++;
            }
            return;
        }
        dfs(numbers,target,total+numbers[idx],idx+1);
        dfs(numbers,target,total-numbers[idx],idx+1);
    }
}