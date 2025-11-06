import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        visited = new boolean[n+1];
        for(int i = 1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 1; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i,i);
                visited[i] = false;
            }
        }
        System.out.println(list.size());
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    private static void dfs(int start, int end) {
        int next = arr[start];
        if(!visited[next]){
            visited[next] = true;
            dfs(next,end);
            visited[next] = false;
        }
        if(next == end){
            list.add(next);
        }
    }
}
