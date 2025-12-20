import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[][] arr = new int[15][2];
    static int max_val = 0;
    static void recur(int cur, int total){
        if(cur > n) return;
        if(cur == n){
            max_val = Math.max(max_val, total);
            return;
        }
        recur(cur+arr[cur][0], total+arr[cur][1]);
        recur(cur+1, total);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        recur(0, 0);
        System.out.println(max_val);
    }
}

