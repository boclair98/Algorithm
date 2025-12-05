import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;
    static int[] parents;
    static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parents[y] = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parents = new int[n+1];
        for(int i = 1; i<=n; i++){
            parents[i] = i;
        }
        for(int i = 0; i<n-2; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        boolean flag = false;
        for(int i  = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(i == j) continue;
                if(find(i) != find(j)){
                    System.out.println(i+" "+j);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
    }

}