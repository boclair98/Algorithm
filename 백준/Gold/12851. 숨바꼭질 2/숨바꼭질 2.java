import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n,k;
    static int[] arr = new int[100001];
    static int min_val = Integer.MAX_VALUE;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if(n>=k){
            System.out.println(n-k);
            System.out.println(1);
            return;
        }
        bfs();
        System.out.println(min_val);
        System.out.println(count);
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        arr[n] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if(min_val < arr[cur]) return;
            for(int i = 0; i < 3; i++){
                int next = 0;
                if(i == 0) next = cur + 1;
                if(i == 1) next = cur - 1;
                if(i == 2) next = cur  * 2;
                if(next < 0 || next > 100000 ) continue;
                if(next == k){
                    min_val = arr[cur];
                    count++;
                }
                if(arr[next] == 0 || arr[next] == arr[cur] + 1){
                    q.add(next);
                    arr[next] = arr[cur] + 1;
                }
            }
        }
    }
}
