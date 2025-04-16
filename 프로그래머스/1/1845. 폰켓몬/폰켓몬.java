import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int num = nums.length/2;
        int max_val = 0 ;
        int count = 0 ;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        if(num < set.size()){
            return num;
        }
        
        return set.size();
    }
}