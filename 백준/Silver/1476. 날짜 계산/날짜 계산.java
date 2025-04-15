import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int a1 = 1;
        int b1 = 1;
        int c1 = 1;
        int count = 1;
        while(true){
            if(a == a1 && b == b1 && c == c1) {
                break;
            }
            a1++;
            b1++;
            c1++;
            if(a1>15){
                a1 = 1;
            }
            if(b1>28){
                b1 = 1;
            }
            if(c1>19){
                c1=1;
            }
            count++;
        }
        System.out.println(count);
    }
}