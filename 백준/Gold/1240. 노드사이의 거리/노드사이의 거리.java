import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m;
    static List<List<int[]>> list = new ArrayList<>();
    static boolean[]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i <=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b,c});
            list.get(b).add(new int[]{a,c});
        }
        while(m -- > 0){
            visited = new boolean[n+1];
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(dfs(start,end,0));
        }
    }
    static int dfs(int start,int end,int cnt){
        if(start == end) return cnt;
        visited[start] = true;
        for(int[] s : list.get(start)){
            if(!visited[s[0]]){
                visited[s[0]] = true;
                int rs = dfs(s[0],end,cnt+s[1]);
                if(rs != -1) return rs;
            }
        }
        return -1;
    }
}
