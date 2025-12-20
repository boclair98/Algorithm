import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if(n%2 == 0) System.out.println("SK");
        else System.out.println("CY");
    }
}

