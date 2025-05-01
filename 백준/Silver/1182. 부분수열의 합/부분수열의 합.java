import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,s,totals;
    static StringTokenizer st;
    static boolean[] check1;
    static int[] arr ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0,0);
        if(s == 0){
            totals--;
        }
        System.out.println(totals);
    }

    private static void DFS(int idx, int total) {
        if(idx == n){
//            System.out.println(total);
            if(total == s){
                totals++;
            }
            return;
        }
        DFS(idx+1,total);
        DFS(idx+1,total+arr[idx]);
    }


}
