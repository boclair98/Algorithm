import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dp = new int[50050];

    static int recur(int num) {
        if (num == 0) return 0;
        if (dp[num] != -1) return dp[num];

        
        int minVal = 4;

        // 큰 제곱수부터 빼는 것이 재귀 깊이를 빨리 줄이는 데 도움이 됩니다.
        for (int i = (int) Math.sqrt(num); i >= 1; i--) {
            int res = recur(num - i * i) + 1;
            minVal = Math.min(minVal, res);
            
        
            if (minVal <= 2) break; 
        }

        return dp[num] = minVal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Arrays.fill(dp, -1);
        System.out.println(recur(n));
    }
}