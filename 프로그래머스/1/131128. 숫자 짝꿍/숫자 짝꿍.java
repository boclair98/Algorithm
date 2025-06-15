import java.util.*;
import java.lang.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int n = X.length();
        int m = Y.length();
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        
        //1:0,2:3 이런 방식으로 숫자가 몇 개 있는 지 확인
        for(int i = 0; i<n; i++){
            char num = X.charAt(i);
            if(map.get(num) == null){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        
        // System.out.println(map);
        
        //Y값과 비교후 값이 있으면 list에 넣어줌
        for(int i = 0; i<m; i++){
            char num = Y.charAt(i);
            if(!map.containsKey(num) || map.get(num) == 0){
                continue;
            }
            if(map.get(num) > 0){
                map.put(num,map.get(num)-1);
                list.add(Integer.parseInt(String.valueOf(num)));
            }
        }
        if(list.isEmpty()){
            return "-1";
        }
        
        Collections.sort(list,Collections.reverseOrder());
        // System.out.println(list);
        for(int w : list){
            sb.append(w);
        }
        
        return sb.charAt(0) =='0' ? "0" : sb.toString();
    }
}