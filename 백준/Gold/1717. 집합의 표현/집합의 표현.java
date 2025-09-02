import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(s == 0){
                union(a,b,parent);
            }else {
                int x = find(a, parent);
                int y = find(b, parent);
                if (x == y) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }

    private static void union(int a, int b,int[] parent) {
        a = find(a,parent);
        b = find(b,parent);
        if(a!=b){
            if(a<b){
                parent[b] = a;
            }else{
                parent[a] = b;
            }
        }

    }

    private static int find(int a,int[] parent) {

        if(a == parent[a]){
            return a;
        }
        return parent[a] = find(parent[a],parent);
    }
}
