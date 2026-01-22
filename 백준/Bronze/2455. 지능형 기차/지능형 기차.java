import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max_val = 0;
        int total = 0;
        for(int i = 0; i < 4; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            total+=b;
            total-=a;
            max_val = Math.max(max_val,total);
        }
        System.out.println(max_val);
    }
}
