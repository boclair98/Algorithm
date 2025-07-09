import java.util.*;

//numbers에 있는 값 정렬
// 맨 앞자리 -> 뒷자리 순으로 정렬
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
