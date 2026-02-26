import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m,r;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] arr = new int[100010];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        for(int i = 0; i <=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }
        Arrays.fill(arr,-1);
        dfs(r,0);
        for(int i = 1; i <= n; i++){
            System.out.println(arr[i]);
        }
    }
    static void dfs(int start,int depth){
        arr[start] = depth;
        for(Integer i : list.get(start)){
            if(arr[i] == -1){
                dfs(i,depth+1);
            }
        }
    }
}
