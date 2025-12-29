import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n, m;
    static int[] arr = new int[10];
    static boolean[] visited = new boolean[10];
    static boolean[] ans = new boolean[10000];
    static boolean sosu(int num){
        if(num < 2) return false;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    static void recur(int num, int total){
        if(num == m){
            if(sosu(total)){
                ans[total] = true;
            }
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                recur(num+1,total+arr[i]);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        recur(0,0);
        int total = 0;
        for(int i = 0; i < 10000; i++){
            if(ans[i]){
                total++;
                System.out.print(i+" ");
            }
        }
        if(total == 0){
            System.out.println(-1);
        }
    }
}

