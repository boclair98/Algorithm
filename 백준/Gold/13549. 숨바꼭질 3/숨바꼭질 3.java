import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n , m;
    static Queue<int[]> q = new ArrayDeque<>();
    static StringTokenizer st;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        Arrays.fill(arr, -1);
        arr[n] = 0;
        q.add(new int[]{n,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int num = cur[0];
            int time = cur[1];
            int prev = num-1;
            int next = num+1;
            int jump = num*2;
            if(num == m){
                System.out.println(arr[num]);
                break;
            }
            if(jump>=0 && jump<=100000 && arr[jump] == -1){
                arr[jump] = arr[num];
                q.add(new int[]{jump,time});
            }
            if(prev>=0 && prev<=100000 && arr[prev] == -1){
                arr[prev] = arr[num] + 1;
                q.add(new int[]{prev,time+1});
            }
            if(next>=0 && next<=100000 && arr[next] == -1){
                arr[next] = arr[num] + 1;
                q.add(new int[]{next,time+1});
            }

        }

    }
}
