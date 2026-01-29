import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        if(num.endsWith("0")){
            int a = Integer.parseInt(num.substring(0, num.length()-2));
            int b = 10;
            System.out.println(a+b);
        }else{
            int a = Integer.parseInt(num.substring(0, num.length()-1));
            int b = Integer.parseInt(String.valueOf(num.charAt(num.length()-1)));
            System.out.println(a+b);
        }

    }
}
