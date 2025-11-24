import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m;
    static int[] ball;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ball = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            ball[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ball);
        long start = 1;
        long end = (long) ball[0] * (long) m;
        long ans = -1;
        while(start<=end){
            long mid = (start + end) / 2;
            long count = 0;
            for(int i = 0; i<n; i++){
                count+=(mid / ball[i]);
            }
            if(count < m){
                start = mid + 1;
            }else{
                ans = mid;
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }

}
