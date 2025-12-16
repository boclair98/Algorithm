import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(n-->0){
            int cost = Integer.parseInt(br.readLine());
            int cnt = Integer.parseInt(br.readLine());
            while(cnt-->0){
                st = new StringTokenizer(br.readLine());
                int op = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                cost+=(op*count);
            }
            System.out.println(cost);
        }


    }
}

