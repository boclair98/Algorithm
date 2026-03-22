import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static List<List<int[]>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i<=n; i++){
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
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(dfs(x,y)).append("\n");
        }
        System.out.println(sb);
    }
    static int dfs(int a, int b){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(b);
        visited[b] = true;
        int ans = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int[] s : list.get(cur)){
                if(visited[s[0]]) continue;
                if(s[1] >= a){
                    ans++;
                    visited[s[0]] = true;
                    q.add(s[0]);
                }
            }
        }
        return ans;
    }
}

