import java.util.*;
class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        int n = commands.length;
        List<Integer> total = new ArrayList<>();
        for(int i = 0; i<n; i++){
            List<Integer> list = new ArrayList<>();
            int first = commands[i][0];
            int second = commands[i][1];
            int idx = commands[i][2];
            for(int j = first-1; j<second; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            total.add(list.get(idx-1));
        }
        
        return total;
    }
}