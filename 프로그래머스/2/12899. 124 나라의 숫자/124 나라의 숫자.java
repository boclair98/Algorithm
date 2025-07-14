import java.util.*;
class Solution {
    static String[] nums;
    static StringBuilder sb = new StringBuilder(); ;
    public String solution(int n) {
        String answer = "";
        nums = new String[]{"4","1","2"};
        List<String> word = new ArrayList<>();
        if(n == 1){
            return "1";
        }else if(n == 2){
            return "2";
        }else if(n == 3){
            return "4";
        }
        while(n>0){
            int div = n % 3; 
            sb.append(nums[div]);
            if(div == 0){
                n = n / 3 -1;
            }else{
                n = n / 3;
            }
        
        }
        
        
        return sb.reverse().toString();
    }
}