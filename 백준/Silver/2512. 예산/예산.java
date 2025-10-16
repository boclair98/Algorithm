import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static long[] arr;
    static int n;
    static long total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        total = Long.parseLong(br.readLine());
        arr = new long[n];
        for(int i = 0; i<n; i++){
            arr[i]  = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long start = 0;
        long end = arr[n-1];
        long number = -1;
        while(start<=end){
            long mid = (start + end) / 2;
            if(Check(mid)){
                number = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(number);

    }

    private static boolean Check(long mid) {
        long t =0;
        for(int i = 0; i<n; i++){
            if(arr[i] <= mid){
                t+=arr[i];
            }else{
                t+=mid;
            }
        }
        if(t <= total){
            return true;
        }
        return false;
    }
}
