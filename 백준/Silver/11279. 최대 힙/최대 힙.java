import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o2,o1);
        });
        while(n-->0){
            int num = Integer.parseInt(br.readLine());
            if(num > 0) pq.add(num);
            if(pq.isEmpty() && num == 0){
                sb.append(0).append("\n");
            }else if(num == 0){
                sb.append(pq.poll()).append("\n");
            }
        }
        System.out.println(sb);

    }
}
