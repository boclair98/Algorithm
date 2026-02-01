import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new long[n];
        long end = 0;
        long ans = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(br.readLine());
            end = Math.max(end, arr[i]);
        }
        long start = 1;
        while(start<=end){
            long mid = (start + end) / 2;
            long total = 0;
            for(int i = 0; i < n; i++){
                total+=(arr[i] / mid);
            }
            if(total >= m){
                ans = mid;
                start = mid+1;
            }else {
//                ans = mid;
                end = mid-1;
            }
        }
        System.out.println(ans);


    }
}
