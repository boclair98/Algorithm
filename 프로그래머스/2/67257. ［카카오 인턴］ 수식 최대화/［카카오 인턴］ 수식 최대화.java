//우선 순위를 6가지로 선정
import java.util.*;
class Solution {
    public long solution(String expression) {
        long answer = 0;
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
            for (int idx = 0; idx < 3; idx++) {
                String c = cal.charAt(idx) + "";

                int j = 0;
                while (j < list.size()) {
                    if (list.get(j).equals(c)) {
                        long num1 = Long.parseLong(list.get(j - 1));
                        long num2 = Long.parseLong(list.get(j + 1));
                        long cals = 0;

                        if (c.equals("+")) {
                            cals = num1 + num2;
                        } else if (c.equals("-")) {
                            cals = num1 - num2;
                        } else {
                            cals = num1 * num2;
                        }

                        list.set(j - 1, String.valueOf(cals));
                        list.remove(j); // 연산자
                        list.remove(j); // 다음 숫자
                        j = 0; // 리스트가 변경됐으므로 처음부터 다시 탐색
                        System.out.println(list);
                    } else {
                        j++;
                        }
                    }
                }
            long number = Long.parseLong(list.get(0));
            answer = Math.max(answer,Math.abs(number));
            // System.out.println(list);
            
        }
        return answer;
    }
    
}