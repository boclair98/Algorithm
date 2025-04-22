import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        int idx = 0 ;

        for(int i =2; i<=n; i++){
            dp[i] = dp[i-1] + 1 ;
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i],dp[i/3] + 1);
            }
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i],dp[i/2] + 1);
            }
//            System.out.println(dp[i]);
        }
        System.out.println(dp[n]);



    }
}

