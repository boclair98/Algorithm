import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == m) {
            System.out.println(0);
            return;
        }

        int[] dist = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        dist[n] = 1; // 시작 지점은 방문 표시

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < 3; i++) {
                int cur;
                if (i == 0) {
                    cur = x - 1;
                } else if (i == 1) {
                    cur = x + 1;
                } else {
                    cur = x * 2;
                }
                if (cur < 0 || cur >= 100001) continue;
                if (dist[cur] != 0) continue;

                if (cur == m) {
                    System.out.println(dist[x]);
                    return;
                }

                dist[cur] = dist[x] + 1;
                q.offer(cur);
            }
        }
    }
}
