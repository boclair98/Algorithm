import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> a = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            a.add(arr[i]);
        }
        Collections.sort(a,Collections.reverseOrder());
        a.remove(a.size()-1);
        if(a.isEmpty()){
            a.add(-1);
        }
        List<Integer> b = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            if(a.contains(arr[i])){
                b.add(arr[i]);
            }
        }
        if(b.isEmpty()){
            b.add(-1);
        }
        return b;
    }
}