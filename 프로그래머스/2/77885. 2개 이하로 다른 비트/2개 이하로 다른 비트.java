import java.util.*;

class Solution {
    public List<Long> solution(long[] numbers) {
        List<Long> answer = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++){
            long num = numbers[i];
            String numString = Long.toBinaryString(num);
            if(num%2 == 0){
                answer.add(num+1);
            }else{
                if(numString.contains("0")){
                    int idx = numString.lastIndexOf("0");
                    numString = numString.substring(0,idx) + "10"+numString.substring(idx+2);
                }else{
                    numString = "10"+numString.substring(1);
                }
                answer.add(Long.parseLong(numString,2));
            }
        }

        return answer;
    }

    
}
