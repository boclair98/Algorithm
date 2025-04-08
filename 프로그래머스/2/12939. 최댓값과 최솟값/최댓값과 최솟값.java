import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String number = "";
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<s.length(); i++){
            char word = s.charAt(i);
            if(word==' '){
                list.add(Integer.parseInt(number));
                number="";
            }else{
                number+=word;
            }
        }
        
        list.add(Integer.parseInt(number));
        Collections.sort(list);
        answer+=list.get(0);
        answer+=" ";
        answer+=list.get(list.size()-1);
       
        return answer;
    }
}