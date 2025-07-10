import java.util.*;
class Solution {
    public List<Integer> solution(int[] sequence, int k) {
        List<Integer> answer = new ArrayList<>();
        int left = 0;
        int right = 0;
        int total = 0;
        int max = sequence.length;
        int distance = Integer.MAX_VALUE;
        
        while(right < max){
            total+=sequence[right];
            while(total > k){
                total-=sequence[left];
                left++;
            }
            // System.out.println(total);
            if(total == k){
                if(right - left < distance){
                    distance = right - left;
                    answer.add(left);
                    answer.add(right);
                }
            }
            right++;
        }
        List<Integer> l = new ArrayList<>();
        l.add(answer.get(answer.size()-2));
        l.add(answer.get(answer.size()-1));
        
        return l;
    }
}