import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BigInteger n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = new BigInteger(br.readLine());
        char cal = br.readLine().charAt(0);
        m = new BigInteger(br.readLine());
        if(cal == '*'){
            System.out.println(n.multiply(m));
        }else if (cal == '+'){
            System.out.println(n.add(m));
        }
    }
}
