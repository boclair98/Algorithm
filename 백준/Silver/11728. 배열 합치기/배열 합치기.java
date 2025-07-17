import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        int[] arr = new int[n+m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        int a = 0,b = 0;
        int idx = 0;
        while(a < n && b < m){
            if(arr1[a]<=arr2[b]){
                sb.append(arr1[a++]).append(" ");
            }else{
                sb.append(arr2[b++]).append(" ");
            }
        }
        if(b == m){
            for(int i = a; i<n; i++){
                sb.append(arr1[i]).append(" ");
            }
        }else{
            for(int i = b; i<m; i++){
                sb.append(arr2[i]).append(" ");
            }
        }

        System.out.print(sb.toString());
    }
}