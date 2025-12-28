import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static long n;
    static long[] arr = new long[100000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[(int)n]*2  + arr[(int)n-1] * 2);
    }
}

