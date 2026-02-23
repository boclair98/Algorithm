import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,t;
    static int[] arr;
    static PriorityQueue<int[]> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while(t-->0){
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            pq = new PriorityQueue<>((o1,o2)->{
                if(o1[0] == o2[0]) return Integer.compare(o1[1],o2[1]);
                return Integer.compare(o1[0],o2[0]);
            });
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                pq.add(new int[]{a,b});
            }
            int count = 0;
            int max_val = Integer.MAX_VALUE;
            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                int rank = cur[1];
                if(max_val > rank){
                    max_val = rank;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
