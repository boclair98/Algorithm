//우선 처음에 확인을해줌 올바른 괄호 문자열인지.
//1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
//2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
//3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
  //3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
//4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
  //4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
  //4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
  //4-3. ')'를 다시 붙입니다. 
  //4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
  //4-5. 생성된 문자열을 반환합니다.

import java.util.*;
class Solution {
    public String solution(String p) {
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
    
    
    //검증 함수
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