import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int start = 0;
        while (true){
            if(n == 0 ){
                break;
            }
            if(n%2 == 0){
                n = n /2;
            }
            if(n%2 == 1){
                n = n /2 ;
                ans++;
            }
            
        }
        
        return ans;
    }
}