import java.util.*;
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int max_val = Math.max(wallet[0],wallet[1]);
        int min_val = Math.min(wallet[0],wallet[1]);
        boolean found = false;
        Arrays.sort(wallet);
        Arrays.sort(bill);
        while(true){
            for(Integer s : bill){
                System.out.print(s+" ");
            }
            int count = 0;
            
            for(int i = 0; i<2; i++){
                if(wallet[i] >=bill[i]){
                    count++;
                }
            }
            if(count == 2){
                break;
            }
            
            bill[1] = bill[1] / 2 ; 
            Arrays.sort(bill);
            answer++;
            
            
        }
        
        return answer;
    }
}