import java.util.*;
class Solution {
    public int solution(String s) {
        String answer = "";
        String an ="";
        Map<String,Integer> map = new HashMap<>();
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
        for(int i = 0; i<s.length(); i++){
            char word = s.charAt(i);
            if(word>='0' && word<='9'){
                answer+=word;
            }else{
                an+=word;
                if(map.containsKey(an)){
                    answer+=map.get(an);
                    an="";
                }
            }
        }
        int last = Integer.parseInt(answer);
        return last;
    }
}