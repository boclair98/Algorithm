import java.util.*;
class Solution {
    static StringBuilder sb = new StringBuilder(); ;
    public String solution(int n) {
        String answer = "";
        //412로 구분 
        //나머지가 0으로 끝나면 4로 하기 위해서
        String[] nums = new String[]{"4","1","2"};
        List<String> word = new ArrayList<>();
        if(n == 1){
            return "1";
        }else if(n == 2){
            return "2";
        }else if(n == 3){
            return "4";
        }
        
        while(n>0){
            //우선 기존 숫자를 3으로 나눈다.
            int div = n % 3; 
            
            //나머지를 추가해준다.
            sb.append(nums[div]);
            //나머지가 0이라면 n / 3 -1 을 해줘야 겹치지 않는다.
            //0이 아니라면 계속 3으로 나눠주고 while 문 실행.
            if(div == 0){
                n = n / 3 -1;
            }else{
                n = n / 3;
            }
        
        }
        
        //처음에 나머지지를 기준으로 넘었으니 반환할때는 반대로 
        // 7 -> 몫2 나머지 1이니-> 1추가
        // 2 -> 몫 0 나머지 2  -> 2 추가
        // 반환할떄는 21
        return sb.reverse().toString();
    }
}