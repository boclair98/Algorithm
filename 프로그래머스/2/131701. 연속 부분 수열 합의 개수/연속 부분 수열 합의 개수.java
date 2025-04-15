import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> number = new HashSet<>();
        int n = elements.length; 
        for(int i = 0; i<n; i++){
            int total = 0;
            for(int j = 0; j<n; j++){
                total+=elements[(i+j)%n];
                // System.out.println(total);
                number.add(total);
            }
        }
        // System.out.println(number);
        return number.size();
    }
}