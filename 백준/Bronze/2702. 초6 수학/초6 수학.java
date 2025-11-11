import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(n -- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.print(lcm(a,b)+" "+ gcd(a,b));
            System.out.println();
        }
    }
    static int gcd(int a, int b){
        while(b!=0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
    static int lcm(int a, int b){
        return a / gcd(a,b) * b;
    }
}
