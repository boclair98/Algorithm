import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        
        for(int i = 1; i<=number; i++){
            int count = 0 ;
            for(int j =1; j<=(int)Math.sqrt(i+1); j++ ){
                if((i+1)%j == 0){
                    count++;
                    if((i+1)/j!=j){
                        count++;
                    }
                }
            }
            list.add(count);
            
        }
        // System.out.println(list);
        for(int i = 0; i<number; i++){
            if(list.get(i)>limit){
                answer+=power;
            }else{
                answer+=list.get(i);
            }
        }
        return answer;
    }
}