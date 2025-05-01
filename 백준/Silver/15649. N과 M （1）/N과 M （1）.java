import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] num;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[m];
        visited = new boolean[n];
        
        DFS(0);

    }

    private static void DFS(int s) {
        if(s == m){
            for (int i1 : num) {
                System.out.print(i1+" ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i<n; i++){
            if (!visited[i]){
                visited[i] = true;
                num[s] = i + 1;
                DFS(s+1);
                visited[i] = false;
            }
        }
    }


}