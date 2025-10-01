import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int a,b,n,m;
    static boolean[] visited;
    static int total = 0;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        graph = new ArrayList<>();
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(s).add(y);
            graph.get(y).add(s);
        }
        System.out.println(bfs(a,b));
    }

    private static int bfs(int start, int end) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start,0});
        visited[start] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int node = cur[0];
            int dist = cur[1];
            if(node == end) return dist;
            for(int number : graph.get(node)){
                if(!visited[number]){
                    visited[number] = true;
                    q.add(new int[]{number,dist+1});
                }
            }
        }
        return -1;
    }


}
