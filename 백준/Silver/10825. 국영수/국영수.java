import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<String[]> pq = new PriorityQueue<>((o1,o2) ->{
            int a = Integer.parseInt(o1[1]);
            int b = Integer.parseInt(o1[2]);
            int c = Integer.parseInt(o1[3]);
            int a1 = Integer.parseInt(o2[1]);
            int b1 = Integer.parseInt(o2[2]);
            int c1 = Integer.parseInt(o2[3]);
            if(a!=a1) return Integer.compare(a1,a);
            if(b!=b1) return Integer.compare(b,b1);
            if(c!=c1) return Integer.compare(c1,c);
            return o1[0].compareTo(o2[0]);

        });

        for(int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            pq.add(new String[]{s[0],s[1],s[2],s[3]});
        }
        for(int i = 1; i <= n; i++) {
            System.out.println(pq.poll()[0]);
        }

    }
}
