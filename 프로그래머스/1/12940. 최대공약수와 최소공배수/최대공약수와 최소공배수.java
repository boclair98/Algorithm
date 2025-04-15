import java.util.*;

class Solution {
    public List<Integer> solution(int n, int m) {
        List<Integer> list = new ArrayList<>();
        
        
        int gcd = getGCD(n, m);
        list.add(gcd);
        
        int lcm = (n * m) / gcd;
        list.add(lcm);
        
        return list;
    }

    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
