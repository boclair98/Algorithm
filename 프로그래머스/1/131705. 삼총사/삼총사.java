import java.util.*;
class Solution {
    public int solution(int[] number) {
        int answer = 0;
        Arrays.sort(number);
        int len = number.length;
        for(int i = 0; i<len; i++){
            for(int j = i+1; j<len; j++){
                for(int k = j+1; k<len; k++){
                    int total = number[i] + number[j] + number[k];
                    if(total == 0){
                        answer++;
                    }else if(total > 0){
                        break;
                    }
                }
            }
        }
        return answer;
    }
}