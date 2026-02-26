import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m;
    static int[] parents;
    static int find(int x){
        if(parents[x]==x) return x;
        return parents[x] = find(parents[x]);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            if(x < y){
                parents[y]=x;
            }else{
                parents[x]=y;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n+1];
        for(int i=0;i<=n;i++){
            parents[i] = i;
        }
        while(m -- > 0){
            st = new StringTokenizer(br.readLine());
            int cn = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(cn == 0){
                union(a,b);
            }
            if(cn == 1){
                int x = find(a);
                int y = find(b);
                if(x == y) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}
