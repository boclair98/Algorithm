import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    static int n;
    static int[] dp ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        System.out.println(bfs(n));
    }

    private static int bfs(int depth) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] v = new boolean[depth+1];
        q.add(new int[]{depth,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int next = cur[0];
            int count = cur[1];
            if(next == 1) return count;
            if(next  % 3 == 0 && !v[next / 3]){
                q.add(new int[]{next / 3,count+1});
                v[next / 3] = true;
            }
            if(next % 2 == 0 && !v[next/2]){
                q.add(new int[]{next / 2,count+1});
                v[next / 2] = true;
            }
            if(!v[next-1]){
                q.add(new int[]{next-1,count+1});
                v[next-1] = true;
            }
            
        }
        return -1;
    }


}
