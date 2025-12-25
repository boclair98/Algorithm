import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n;
    static int[] a = new int[100];
    static int[] b = new int[100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a[1] = 0;
        b[1] = 1;
        a[2] = 1;
        b[2] = 1;
        a[3] = 1;
        b[3] = 2;
        for(int i = 4; i<=50; i++){
            a[i] = a[i-2] + a[i-1];
            b[i] = b[i-2] + b[i-1];
        }
        System.out.println(a[n]+" "+b[n]);
    }
}