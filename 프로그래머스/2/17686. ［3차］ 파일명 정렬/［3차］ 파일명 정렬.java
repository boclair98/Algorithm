import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        Arrays.sort(files, (o1,o2)->{
            String word1 ="";
            String word2 ="";
            for(int i = 0; i < o1.length(); i++){
                char s = o1.charAt(i);
                if(s <='9' && s >='0') break;
                word1+=s;
            }
            for(int i = 0; i < o2.length(); i++){
                char s = o2.charAt(i);
                if(s <='9' && s >='0') break;
                word2+=s;
            }
            int headCompare = word1.compareToIgnoreCase(word2);
            if (headCompare != 0) {
                return headCompare;
            }
            
            String number1 ="";
            String number2 ="";
            boolean flag1 = false;
            boolean flag2 = false;
            for(int i = 0; i < o1.length(); i++){
                char s = o1.charAt(i);
                if(s <='9' && s >='0'){
                    number1+=s;
                    flag1 = true;
                }else if(flag1){
                    break;
                }
            }
            for(int i = 0; i < o2.length(); i++){
                char s = o2.charAt(i);
                if(s <='9' && s >='0'){
                    number2+=s;
                    flag2 = true;
                }else if(flag2){
                    break;
                }
            }
             return Integer.compare(Integer.parseInt(number1), Integer.parseInt(number2));         
        });
        for(int i = 0; i < files.length; i++){
            answer[i] = files[i];
        }
        return answer;
    }
}