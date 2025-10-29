import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int answer = 0;
        int[][] dp = new int[1001][10];
        for(int i = 0; i<=9; i++){
            dp[1][i] = 1;
        }
        for(int i = 2; i<=1000; i++){
            dp[i][0] = 1;
            for(int j = 1; j<10; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] = dp[i][j] % 10007;
            }
        }
        for(int i = 0; i<=9; i++){
            answer = (answer + dp[n][i]) % 10007;
        }
        System.out.println(answer);

    }


}
