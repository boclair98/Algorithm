import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[][] arr = new int[15][2];
    static boolean[] visited = new boolean[15];
    static int min_val = Integer.MAX_VALUE;
    static void recur(int idx, int s, int ss,int use){
        if(idx == n){
            if(use > 0){
                if(ss > s){
                    min_val = Math.min(min_val, ss-s);
                }else{
                    min_val = Math.min(min_val, s-ss);
                }
            }
            return;
        }
        recur(idx+1,s*arr[idx][0],ss+arr[idx][1],use+1);
        recur(idx+1,s,ss,use);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        recur(0,1,0,0);
        System.out.println(min_val);
    }
}

