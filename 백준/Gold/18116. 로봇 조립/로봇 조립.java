import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[] parents = new int[1000001];
    static int[] cnt = new int[1000001];
    static StringBuilder sb = new StringBuilder();
    static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            if(x < y){
                parents[y] = x;
                cnt[x]+=cnt[y];
            }else{
                parents[x] = y;
                cnt[y]+=cnt[x];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i=1;i<=1000000;i++){
            parents[i] = i;
            cnt[i] = 1;
        }

        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);

            if(cmd == 'I'){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            } else {
                int x = Integer.parseInt(st.nextToken());
                sb.append(cnt[find(x)]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }


}
