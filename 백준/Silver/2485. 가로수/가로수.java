import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long gcdNum = 0;
        for(int i = 0; i < n-1; i++){
            int num = arr[i+1] - arr[i];
            gcdNum = gcd(gcdNum,num);
        }
        System.out.println((arr[n-1] - arr[0]) / gcdNum+1 - (n));
    }

    private static long gcd(long a, long b) {
        while(b!=0){
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
