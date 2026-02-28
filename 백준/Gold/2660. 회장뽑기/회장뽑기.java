import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] dist;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        distance = new int[n+1];
        for(int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }
        while (true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1)break;
            list.get(a).add(b);
            list.get(b).add(a);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            distance[i] = bfs(i);
            min = Math.min(min, distance[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(distance[i] == min){
                ans.add(i);
            }
        }
        System.out.println(min+" "+ans.size());
        for (Integer an : ans) {
            System.out.print(an+" ");
        }
    }
    static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[start] = 0;
        int max_dist = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int num : list.get(cur)){
                if(dist[num] == -1){
                    dist[num] = dist[cur] + 1;
                    q.add(num);
                    max_dist = Math.max(max_dist, dist[num]);
                }
            }
        }
        return max_dist;
    }

}
