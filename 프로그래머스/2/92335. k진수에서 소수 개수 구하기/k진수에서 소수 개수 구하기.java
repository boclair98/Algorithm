import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String num = Integer.toString(n,k);
        String aw = "";
        
        for(int i = 0; i<num.length(); i++){
            if(num.charAt(i)!='0'){
                aw+=num.charAt(i);
            }else{
                if(!aw.equals("")){
                    Long nums = Long.parseLong(aw);
                    if(CheckSosu(nums)){
                        answer++;
                    }
                    aw ="";
                }
            }
        }
        
        //마지막 처리
        if (!aw.equals("")) {
            Long nums = Long.parseLong(aw);
            if (CheckSosu(nums)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    //소수 판별 
    public boolean CheckSosu(Long num){
        if(num<=1){
            return false;
        }
        for(int i = 2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}