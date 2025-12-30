import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n, m;
    static int[] arr = new int[100];
    static int ans = 0;
    static void recur(int idx, int size,int time){
        if(idx == n-1 || time == m){
            ans = Math.max(ans, size);
            return;
        }
        if(idx + 1 < n){
            recur(idx+1, size+arr[idx+1], time+1);
        }
        if(idx + 2 < n){
            recur(idx+2, size / 2 +arr[idx+2], time+1);
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        recur(-1,1,0);
        System.out.println(ans);

    }
}

