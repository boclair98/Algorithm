import java.util.*;
class Solution {
    
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] num = new String[numbers.length];
        
        for(int i = 0; i<numbers.length; i++){
            num[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(num,(a,b) -> (b+a).compareTo(a+b));
        for(int i = 0; i<num.length; i++){
            sb.append(num[i]);
        }
        if(num[0].equals("0")){
            return "0";
        }
        return sb.toString();
    }
}
