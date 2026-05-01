import java.util.*;
class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        Arrays.sort(numbers);
        
        return (double) (numbers[0] + numbers[numbers.length-1]) / 2;
    }
}