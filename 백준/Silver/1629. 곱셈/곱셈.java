import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static long a,b,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        System.out.println(pow(a,b,c));
    }

    private static long pow(long a, long b, long c) {
        if(b == 1) return a % c;
        long val = pow(a, b / 2, c);
        val = val * val  % c;

        if(b % 2 == 0) return val;
        return val * a  % c;


    }
}

