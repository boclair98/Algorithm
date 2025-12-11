import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int idx = 0;
        while(idx<9){
            n-=Integer.parseInt(br.readLine());
            idx++;
        }
        System.out.println(n);
    }
}

