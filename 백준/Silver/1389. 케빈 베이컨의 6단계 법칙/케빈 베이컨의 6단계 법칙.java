import org.w3c.dom.Node;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int n, m, number,numberidx;
    static StringTokenizer st;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
//        System.out.println(list);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        number = Integer.MAX_VALUE;
        numberidx = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            BFS(i);
        }
        System.out.println(numberidx);


    }

    private static void BFS(int num) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.offer(num);
        visited[num] = true;
        int[] dist = new int[n + 1];
        dist[num] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : list.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
        int total = 0;
        for (int i : dist) {
            total+=i;
        }
//        System.out.println(total);
        if(total < number){
            number = total;
            numberidx = num;
        }

    }
}





