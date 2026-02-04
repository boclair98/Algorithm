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
            if(pq.size() == 0 && num == 0){
                System.out.println(0);
            }else if(num == 0){
                System.out.println(pq.poll());
            }
        }

    }
}
