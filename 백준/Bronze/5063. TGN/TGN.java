import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            long r = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            long num = e-c;
            if(r < num) System.out.println("advertise");
            if(r == num) System.out.println("does not matter");
            if(r > num) System.out.println("do not advertise");
        }
    }

}
