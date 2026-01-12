import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, count;
    static int[][] arr;
    static void recur(int idx){
        if(idx == n){
            int broken = 0;
            for(int i = 0; i < n; i++){
                if(arr[i][0] <= 0) broken++;
            }
            count = Math.max(count,broken);
            return;
        }
        if(arr[idx][0] <=0){
            recur(idx+1);
            return;
        }
        boolean hit = false;
        for(int i = 0; i < n; i++){
            if(i == idx || arr[i][0]<=0) continue;
            hit = true;
            arr[i][0]-= arr[idx][1];
            arr[idx][0]-= arr[i][1];
            recur(idx+1);
            arr[i][0]+= arr[idx][1];
            arr[idx][0]+= arr[i][1];
        }
        if(!hit) recur(idx+1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        recur(0);
        System.out.println(count);

    }
}