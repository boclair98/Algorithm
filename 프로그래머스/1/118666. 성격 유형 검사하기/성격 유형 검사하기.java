

import java.util.*;
import java.lang.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        Map<Character ,Integer> kakao = new HashMap<>();
        kakao.put('R',0);
        kakao.put('T',0);
        kakao.put('C',0);
        kakao.put('F',0);
        kakao.put('J',0);
        kakao.put('M',0);
        kakao.put('A',0);
        kakao.put('N',0);
        
        for(int i = 0 ; i<survey.length; i++){
            char name1 = survey[i].charAt(0);
            char name2 = survey[i].charAt(1);
            int score = choices[i];
            if(score<4){
                if(score == 1){
                    kakao.put(name1,kakao.get(name1)+3);
                }else if(score == 2){
                    kakao.put(name1,kakao.get(name1)+2);
                }else if( score == 3){
                    kakao.put(name1,kakao.get(name1)+1);
                }
            }else{
                if(score == 5){
                    kakao.put(name2,kakao.get(name2)+1);
                }else if(score == 6){
                    kakao.put(name2,kakao.get(name2)+2);
                    
                }else if(score == 7) {
                    kakao.put(name2,kakao.get(name2)+3);
                }
            }
        }
        if(kakao.get('R') < kakao.get('T')){
            answer+="T";
        }else{
            answer+="R";
        }
        if(kakao.get('C') < kakao.get('F')){
            answer+="F";
        }else{
            answer+="C";
        }
        if(kakao.get('J') < kakao.get('M')){
            answer+="M";
        }else{
            answer+="J";
        }
        if(kakao.get('A') < kakao.get('N')){
            answer+="N";
        }else{
            answer+="A";
        }
        
        
        
        return answer;
    }
}