import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m ;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        for(int i = 1; i<=n; i++){
            arr[i] = i;
        }
        int[][] map = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(map[i][j] == 1 ){
                    union(i,j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        boolean flag = false;
        for(int i = 0; i<m-1; i++){
            if(start != find(Integer.parseInt(st.nextToken()))){
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }

    }

    private static void union(int a, int b) {
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
    static int find(int a){
        if(a == arr[a]){
            return a;
        }
        return arr[a] = find(arr[a]);
    }
}
