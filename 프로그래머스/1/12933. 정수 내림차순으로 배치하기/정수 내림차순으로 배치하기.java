import java.util.*;
import java.lang.*;
class Solution {
    public long solution(long n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String number = String.valueOf(n);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i<number.length(); i++){
            arr.add((int) 1* number.charAt(i)-'0');
        }
        Collections.sort(arr,Collections.reverseOrder());
        
        for(int arrs : arr){
            sb.append(arrs);
        }
        return Long.parseLong(sb.toString());
    }
}