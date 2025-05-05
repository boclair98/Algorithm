import java.util.*;

class Solution {
    static boolean[] visited; 
    static int n, maxval;
    static Deque<Integer> q = new ArrayDeque<>();

    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        maxval = 0;
        DFS(0, k, dungeons);
        return maxval;
    }

    static void DFS(int idx, int power, int[][] dungeons) {
        if (idx == n) {
            int count = 0;
            int currPower = power;

            for (Integer s : q) {
                int need = dungeons[s][0];
                int cost = dungeons[s][1];
                if (currPower >= need) {
                    currPower -= cost;
                    count++;
                }
            }

            maxval = Math.max(maxval, count);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                q.offer(i);            
                DFS(idx + 1, power, dungeons);
                q.removeLast();        
                visited[i] = false;
            }
        }
    }
}
