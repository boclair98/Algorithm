import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] arr, int divisor) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i = 0; i<arr.length; i++ ){
            if(arr[i] % divisor == 0){
                a.add(arr[i]);
            }
        }
        if(a.size() == 0){
            a.add(-1);
        }
        Collections.sort(a);
        return a;
    }
}