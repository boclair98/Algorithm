import java.util.*;
class Solution {
    public List<Integer> solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int n = numbers.length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i==j){
                    continue;
                }
                set.add(numbers[i]+numbers[j]);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
}