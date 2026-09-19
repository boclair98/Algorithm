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
            int s = Integer.parseInt(number[i]);
            int next = Integer.parseInt(number[i+1]); // 다음 자릿수 미리 확인
            
            // 1. s가 6 이상이거나, s가 5인데 다음 자릿수도 5 이상일 때 올림 수행
            if(s > 5 || (s == 5 && next >= 5)){
                answer += (10 - s);
                number[i+1] = String.valueOf(next + 1); // 다음 자릿수에 +1 올림
            } else {
                answer += s;
            }
        }
        
        // 2. 마지막 자릿수 처리 (이 자릿수도 이전 루프에서 올라온 값 때문에 10이 될 수 있음)
        int last = Integer.parseInt(number[number.length-1]);
        if(last > 5) {
            answer += (10 - last) + 1; // 10을 채우고 남은 수 + 맨 앞자리에 새로 생긴 '1' 추가
        } else if(last == 5) {
            // 마지막 자릿수가 딱 5라면 내리는 게 이득 (앞에 더이상 자릿수가 없으므로)
            answer += 5;
        } else {
            answer += last;
        }
        
        return answer;
    }
}
