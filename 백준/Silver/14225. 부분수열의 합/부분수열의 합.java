import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n, count;
    static int[] arr = new int[25];
    static boolean[] visited = new boolean[2000050];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        recur(0,0);
        for(int i = 1; i<2000050; i++){
            if(!visited[i]){
                System.out.println(i);
                return;
            }
        }

    }

    private static void recur(int idx, int s) {
        if(idx == n){
            if(s > 0){
                visited[s] = true;
            }
            return;
        }
        recur(idx+1,s+arr[idx]);
        recur(idx+1,s);
    }
}