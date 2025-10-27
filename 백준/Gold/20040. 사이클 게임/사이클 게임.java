import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        for(int i = 0; i<=n; i++){
            arr[i] = i ;
        }
        boolean flag = true;
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a) == find(b)){
                flag = false;
                System.out.println(i+1);
                break;
            }else{
                union(a,b);
            }
        }
        if(flag) System.out.println(0);
    }
    static int find(int a){
        if(a == arr[a]){
            return a;
        }
        return arr[a] = find(arr[a]);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            if(x < y){
                arr[y] = x;
            }else{
                arr[x] = y;
            }
        }
    }

}
