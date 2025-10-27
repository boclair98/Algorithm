import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,k;
    static int[] arr = new int[100001];
    static int[] range = new int[]{2,1,-1};
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Arrays.fill(arr,-1);
        bfs(n);
    }

    private static void bfs(int sx) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(sx);
        arr[sx] = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            if(now == k){
                System.out.println(arr[k]);
                return;
            }
            for(int i = 0 ; i<3; i++){
                if(i == 0){
                    num = now * 2;
                }
                if(i == 1){
                    num = now + 1;
                }
                if(i == 2){
                    num = now - 1;
                }
                if(num >=0 && num<=100000 && arr[num] ==-1){
                    arr[num] = arr[now] + 1;
                    q.add(num);
                }

            }
        }

    }
}
