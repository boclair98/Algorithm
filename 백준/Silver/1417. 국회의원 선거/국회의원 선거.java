import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int dasom;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        //다솜이
        dasom = Integer.parseInt(br.readLine());

        //나머지 기호
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 1; i < n; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        int count = 0;
        while(!pq.isEmpty() && dasom <= pq.peek()){
            int now = pq.poll();
            now--;
            dasom++;
            count++;
            pq.add(now);
        }
        System.out.println(count);
    }
}
