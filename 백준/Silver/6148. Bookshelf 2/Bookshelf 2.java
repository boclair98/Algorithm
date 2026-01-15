import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n, h;
    static int[] arr = new int[20];
    static int min_val = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0,0);
        System.out.println(min_val);

    }

    private static void dfs(int idx,int count) {
        if(count >= h){
            min_val = Math.min(min_val, count - h);
            return;
        }
        if(idx == n){
            return;
        }
        dfs(idx+1, count + arr[idx]);
        dfs(idx+1, count);
    }
}
