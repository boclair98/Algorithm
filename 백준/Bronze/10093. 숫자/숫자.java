import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        // a < b가 되도록 스왑
        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }

        long diff = b - a - 1;
        System.out.println(diff > 0 ? diff : 0);

        for (long i = a + 1; i < b; i++) {
            System.out.print(i + " ");
        }
    }
}
