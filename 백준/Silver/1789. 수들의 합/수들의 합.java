import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static long n,m,total;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        st = new StringTokenizer(br.readLine());
        n = Long.parseLong(br.readLine());
        total = 0;
        long count = 1;
        while(true){
            total+=count;
            if(total > n){
                break;
            }
            count++;
        }
        System.out.println(count-1);
    }
}
