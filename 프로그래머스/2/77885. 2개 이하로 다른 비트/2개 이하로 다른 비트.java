import java.util.*;

//어려움 
//짝수 일 경우에는 뒷자리를 1로만 변경 가능 -> 10(2) -> 11(3) 
//홀수 일 경우에는 여러 가지 조건이 발생 
//우선 홀수 에 0이 있을 경우와 없을 경우가 존재 
//0이 있으면 1101 이 1110
//홀수/짝수 -> 000000  10 -> 2 100-> 4 5 6 7
// 2가지 조건이 1111 1011 -> 1101 011 
// 1111 10111


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
