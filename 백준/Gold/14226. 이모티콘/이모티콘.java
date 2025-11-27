import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static Deque<int[]> dq = new ArrayDeque<>();
    static boolean[][] visited = new boolean[2001][2001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n =Integer.parseInt(br.readLine());
        dq.add(new int[]{1,0,0});
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int now_number = cur[0];
            int save = cur[1];
            int count = cur[2];
            if(now_number == n){
                System.out.println(count);
                break;
            }
            if(!visited[now_number][now_number]){
                visited[now_number][now_number] = true;
                dq.add(new int[]{now_number,now_number,count+1});
            }
            if(save > 0 && now_number+save<=2000 && !visited[now_number+save][now_number]){
                visited[now_number+save][now_number] = true;
                dq.add(new int[]{now_number+save,save,count+1});
            }
            if(now_number-1>=0 && !visited[now_number-1][now_number]){
                visited[now_number-1][now_number] = true;
                dq.add(new int[]{now_number-1,save,count+1});
            }

        }

    }
}
