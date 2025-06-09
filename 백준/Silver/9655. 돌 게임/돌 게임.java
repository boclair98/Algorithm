import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    static int[] dp ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        for(int i = 4; i<=n; i++){
            dp[i] = Math.min(dp[i-1],dp[i-3]) + 1;
//            System.out.println(dp[i]);
        }
        if(dp[n] % 2 == 1){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }


}