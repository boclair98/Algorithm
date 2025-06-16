import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    static class Node{
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[x] = 0;
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,1));
        }
        Queue<Integer> q= new ArrayDeque<>();
        q.offer(x);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(Node node : graph.get(cur)){
                if(dist[node.node] == -1){
                    dist[node.node] = dist[cur] + 1;
                    q.offer(node.node);
                }
            }
        }
        boolean found = false;
        for(int i = 1; i<=n; i++){
            if(dist[i] == k){
                found = true;
                System.out.println(i);
            }
        }
        if(!found){
            System.out.println(-1);
        }


    }

}