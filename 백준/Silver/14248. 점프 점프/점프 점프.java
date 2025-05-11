import java.io.*;
import java.util.*;

public class Main {
    static int n ,k,total;
    static int[] stone;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stone = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            stone[i] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        k--;
        visited[k] = true;
        q.offer(k);
        while(!q.isEmpty()){
            int num = q.poll();
            int left = num - stone[num];
            int right  = num + stone[num];
            if(left>=0 && !visited[left]){
                visited[left] = true;
                q.offer(left);
            }
            if(right<n && !visited[right]){
                visited[right] = true;
                q.offer(right);
            }

        }
        for(int i = 0; i<n; i++){
            if(visited[i]){
                total++;
            }
        }
        System.out.println(total);
    }

}
