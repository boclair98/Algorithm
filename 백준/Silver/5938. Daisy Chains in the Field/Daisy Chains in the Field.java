import javax.imageio.ImageTranscoder;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i <=n; i++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        dfs(1);
        boolean flag = true;
        for(int i = 1; i<= n; i++){
            if(!visited[i]){
                flag = false;
                System.out.println(i);
            }
        }
        if(flag){
            System.out.println(0);
        }
    }
    static void dfs(int idx){
        visited[idx] = true;
        for(Integer s : list.get(idx)){
            if(!visited[s]){
                dfs(s);
            }
        }
    }
}
