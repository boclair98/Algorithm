//우선 순위를 6가지로 선정
import java.util.*;
class Solution {
    public long solution(String expression) {
        long answer = 0;
        //6가지 순위가 나옴
        String[] s = new String[]{"*+-","*-+","+-*","+*-","-+*","-*+"};
        for(int i = 0 ; i < 6 ; i++){
            String cal = s[i];
            StringBuilder sb = new StringBuilder();
            List<String> list = new ArrayList<>();
            //계산해야 할 수식을 리스트로 변환.
            for(int j = 0; j<expression.length(); j++){
                char w = expression.charAt(j);
                if(Character.isDigit(w)){
                    sb.append(w);
                }else{
                    list.add(sb.toString());
                    list.add(String.valueOf(w));
                    sb = new StringBuilder();
                }
            }
            list.add(sb.toString());
            
            //더하기 빼기 곱하기 3가지만 있기 때문에
            for(int idx = 0; idx < 3; idx++){
                String formula = cal.charAt(idx)+"";
                // System.out.println(formula);
                int count = 0;
                while(count < list.size()){
                    if(list.get(count).equals(formula)){
                        long num1 = Long.parseLong(list.get(count-1));
                        long num2 = Long.parseLong(list.get(count+1));
                        if(formula.equals("+")){
                            list.set(count-1,String.valueOf(num1+num2));
                        }else if(formula.equals("-")){
                            list.set(count-1,String.valueOf(num1-num2));
                        }else{
                            list.set(count-1,String.valueOf(num1*num2));
                        }
                        //계산후 계산했던 수식과 숫자는 지워줌.
                        list.remove(count);
                        list.remove(count);
                        System.out.println(list);
                        //count 초기화 후 계속 수식있을 때 까지 넣어줌.
                        count = 0;
                    }else{
                        count++;
                    }
                    
                }
            }
            //남은 숫자가 결과인데 최대값 비교
            long number = Long.parseLong(list.get(0));
            answer = Math.max(answer,Math.abs(number));
            // System.out.println(list);
            
        }
        return answer;
    }
    
}