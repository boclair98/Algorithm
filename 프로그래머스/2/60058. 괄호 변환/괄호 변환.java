//우선 처음에 확인을해줌 올바른 괄호 문자열인지.
import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        boolean check = true;
        List<Character> list = new ArrayList<>();
        //검증
        
        if(check(p)){
            return p;
        }
        return dfs(p);
    }
    private static String dfs(String p){
        if(p.length() == 0){
            return"";
        }
        int count1 = 0;
        int count2 = 0;
        int idx = 0;
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        for(int i = 0; i<p.length(); i++){
            if(p.charAt(i) ==')'){
                u.append(')');
                count2++;
            }else{
                u.append('(');
                count1++;
            }
            if(count1 == count2){
                idx = i+1;
                break;
            }
        }
       for(int i = idx; i<p.length(); i++){
           v.append(p.charAt(i));
       }
       if(check(u.toString())){
           return u.toString()+dfs(v.toString());
       }else{
           StringBuilder word = new StringBuilder();
           StringBuilder word2 = new StringBuilder();
           word.append("(").append(dfs(v.toString())).append(")");
           for(int i = 1; i<u.length()-1; i++){
               if(u.charAt(i) ==')'){
                   word2.append("(");
               }else{
                   word2.append(")");
               }
           }
           word.append(word2);
           return word.toString();
       }
        
    
        
    }
    
    private static boolean check(String p){
        boolean check = true;
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i)==')' && list.size() == 0){
                check = false;
                break;
            }
            if(p.charAt(i) =='('){
                list.add('(');
            }else if(list.get(list.size()-1) =='(' && p.charAt(i)==')'){
                list.remove(list.size()-1);
            }
        }
        return check;
    }
}