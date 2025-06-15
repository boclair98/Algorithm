import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String alpha ="abcdefghijklmnopqrstuvwxyz";
        int lenalpha = alpha.length();
        List<Character> list = new ArrayList<>();
        int idx = -1 ;
        
        for(int i = 0; i<skip.length(); i++){
            list.add(skip.charAt(i));
        }
        
        for(int i = 0; i<s.length(); i++){
            int count = 0 ;
            
            for(int k = 0; k<lenalpha; k++){
                if(s.charAt(i) == alpha.charAt(k)){
                    idx = k;
                    break;
                }
            }
            while (count < index){
                for(int j = idx+1; j<lenalpha; j++){
                    if(!list.contains(alpha.charAt(j%lenalpha))){
                        count++;
                    }
                    if(count == index ){
                        answer+= alpha.charAt(j%lenalpha);
                        break;
                    }
                }
                idx = -1 ;
            }
        }
        
        
        return answer;
    }
}