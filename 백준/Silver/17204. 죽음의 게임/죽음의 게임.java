import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,k;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int idx = 0;
        while(true){
            count++;
            int next = arr[idx];
            if(next == k){
                System.out.println(count);
                return;
            }
            if(visited[next]){
                System.out.println(-1);
                return;
            }
            visited[next] = true;
            idx = next;
        }
    }
}
