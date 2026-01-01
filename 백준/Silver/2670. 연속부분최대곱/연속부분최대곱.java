import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n ;
    static double[] arr = new double[10050];
    static double[] dp = new double[10050];
    static double max_val;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        max_val = arr[1];
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(arr[i], dp[i-1] * arr[i]);
            max_val = Math.max(max_val, dp[i]);
        }
        System.out.print(String.format("%.3f", max_val));


    }
}

