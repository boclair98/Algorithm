import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int n,m;
    static int[] cl;
    static int[] parents;
    static int find(int x){
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
    static void union(int x,int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parents[y] = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n+1];
        cl = new int[n+1];
        for(int i=1;i<=n;i++){
            parents[i] = i;
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);
        }
        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=n; i++){
            cl[i] = Integer.parseInt(st.nextToken());
        }
        int total = 0;
        for(int i = 1; i<=n-1; i++){
            if(find(cl[i])!=find(cl[i+1])){
                total++;
            }
        }
        System.out.println(total);
    }
}
