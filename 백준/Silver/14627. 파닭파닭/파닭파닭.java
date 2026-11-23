import javax.imageio.ImageTranscoder;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;
    static long end,start,ans,total,idx;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new long[n];
        start = 1;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            end = Math.max(end,arr[i]);
            total+=arr[i];
        }
        while(start<=end){
            long mid = (start + end) / 2;
            long count = 0;
            for(int i = 0; i < n; i++){
                count+=(arr[i] / mid);
            }
            if(count >= m){
                idx = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        System.out.println(total - (idx * m));
    }
}
