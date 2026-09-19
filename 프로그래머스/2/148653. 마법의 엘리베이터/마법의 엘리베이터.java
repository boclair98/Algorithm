import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        String num = String.valueOf(storey);
        String[] number = new String[num.length()];
        for(int i = 0 ; i < num.length(); i++){
            number[i] = String.valueOf(num.charAt(num.length()-1-i));
        }
        
        for(int i = 0; i < number.length-1; i++){
            int now  = Integer.parseInt(number[i]);
            int next = Integer.parseInt(number[i+1]);
            if(now > 5 || (now == 5 && next >= 5)){
                answer+=(10-now);
                number[i+1] = String.valueOf(Integer.parseInt(number[i+1])+1);
            }else{
                answer+=now;
            }
        }    
        int lastnumber = Integer.parseInt(number[number.length-1]);
        if(lastnumber > 5){
            answer+=(10-lastnumber+1);
        }else{
            answer+=lastnumber;
        }
        return answer;
    }
}