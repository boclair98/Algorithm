import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] w = br.readLine().split(",");
            System.out.println(Integer.parseInt(w[0])+Integer.parseInt(w[1]));
        }

    }
}

