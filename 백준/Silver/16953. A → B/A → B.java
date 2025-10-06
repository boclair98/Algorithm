import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        System.out.println(bfs(n,m));
    }

    private static long bfs(long start, long end) {
        Queue<long[]> q = new ArrayDeque<>();
        q.add(new long[]{start,1});
        while(!q.isEmpty()) {
            long[] cur = q.poll();
            long num = cur[0];
            long count = cur[1];
            if(num == end){
                return count;
            }
            if(num  > end ) continue;
            q.add(new long[]{num*2,count+1});
            String value = String.valueOf(num)+"1";
            q.add(new long[]{Long.parseLong(value),count+1});
        }
        return -1;
    }
}
