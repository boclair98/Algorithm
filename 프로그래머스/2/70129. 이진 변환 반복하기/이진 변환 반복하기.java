import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        List<Character> list = new ArrayList<>();
        int cnt = 0;
        int totalzero = 0;
        while (true){
            if(s.length() == 1){
                break;
            }
            cnt++ ;
            int zerocnt = 0;
            for(Character c : s.toCharArray()){
                if(c == '0'){
                    zerocnt++;
                }
            }
            totalzero+=zerocnt;
            int num = s.length() - zerocnt;
            s =Integer.toBinaryString(num);
            
        }
        // System.out.println(cnt+" "+totalzero);
        answer[0] = cnt;
        answer[1] = totalzero;
        return answer;
    }
}