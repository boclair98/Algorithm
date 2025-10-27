import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,k,a,b,m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            System.out.println("Scenario "+(i+1)+":");
            k = Integer.parseInt(br.readLine());
            int cnt = Integer.parseInt(br.readLine());
            arr = new int[k+1];
            for(int j = 0; j<=k; j++){
                arr[j] = j;
            }
            for(int j = 0; j<cnt; j++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                union(a,b);
            }
            m = Integer.parseInt(br.readLine());
            for(int j = 0; j<m; j++){
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                if (find(num1) == find(num2)){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
            System.out.println();
        }
    }
    static int find(int a){
        if(a == arr[a]){
            return a;
        }
        return arr[a] = find(arr[a]);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            if(a<b){
                arr[b] = a;
            }else{
                arr[a] = b;
            }
        }
    }
}
