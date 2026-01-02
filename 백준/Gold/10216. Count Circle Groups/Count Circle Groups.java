import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int t, n;
    static List<int[]> list;
    static int[] graph;
    static int find(int x){
        if(graph[x] == x) return x;
        return graph[x] = find(graph[x]);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x < y){
            graph[y] = x;
        }else{
            graph[x] = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(br.readLine());
        while(t -- > 0){
            int ans = 0;
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            graph = new int[n+1];
            for(int i = 0; i<=n ;i++){
                graph[i] = i;
            }
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list.add(new int[]{a,b,c});
            }

            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    int[] p1 = list.get(i);
                    int[] p2 = list.get(j);
                    int dx = p1[0] - p2[0];
                    int dy = p1[1] - p2[1];
                    int rSum = p1[2] + p2[2];

                    if (dx * dx + dy * dy <= rSum * rSum) {
                        union(i, j);
                    }
                }
            }
            
            for(int i = 1; i<=n; i++){
                if(graph[i] == i){
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}