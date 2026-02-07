import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(n -- > 0){
            int t = Integer.parseInt(br.readLine());
            PriorityQueue<String[]> pq = new PriorityQueue<>((o1,o2) ->{
                int a = Integer.parseInt(o1[0]);
                int b = Integer.parseInt(o2[0]);
                return Integer.compare(b,a);
            });
            for(int i = 0 ; i < t ; i++){
                String[] name_price = br.readLine().split(" ");
                pq.add(new String[]{name_price[0],name_price[1]});
            }
            System.out.println(pq.poll()[1]);
        }
    }
}