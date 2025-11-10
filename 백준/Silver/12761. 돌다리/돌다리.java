import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int a,b,start,end;
    static Deque<int[]> dq;
    static boolean[] visited = new boolean[100010];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dq = new ArrayDeque<>();
        dq.add(new int[]{start,0});
        visited[start] = true;
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int now = cur[0];
            int count = cur[1];
            if(now == end){
                System.out.println(count);
                break;
            }
            int[] next = {now + 1,now -1,now+a,now+b,now-a,now-b,now*a,now*b};
            for(int i = 0 ; i<8; i++){
                int nx = next[i];
                if(nx<0 || nx>100000) continue;
                if(!visited[nx]){
                    visited[nx] = true;
//                    visited[nx] = true;
                    dq.add(new int[]{nx,count+1});
                }
            }

        }
    }
}
