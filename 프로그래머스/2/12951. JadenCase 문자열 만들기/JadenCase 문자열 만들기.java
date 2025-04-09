import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String ans = "";
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i<s.length(); i++){
            char word = s.charAt(i);
            if(word>='0' && word<='9'){
                answer+=word;
            }else if((word>='a' && word<='z') || (word>='A' && word<='Z') ){
                if(answer.length() == 0){
                    answer+=Character.toUpperCase(word);
                }else{
                    answer+=Character.toLowerCase(word);;
                }
            }else if(word ==' '){
                list.add(answer);
                answer="";
            }
        }
        list.add(answer);
        for(int i = 0 ; i<list.size(); i++){
            if(i <list.size()-1){
                ans+=list.get(i);
                ans+=" ";
            }else{
                ans+=list.get(i);
            }
        }
        return ans;
    }
}