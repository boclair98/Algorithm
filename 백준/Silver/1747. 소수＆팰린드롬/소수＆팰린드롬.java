import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean falinD(int num){
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        String s = sb.toString();
        String s1 = sb.reverse().toString();
        return s.equals(s1);
    }
    static boolean sosu(int num){
        if (num < 2) return false;
        for(int i = 2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(true){
            if(falinD(n) && sosu(n)){
                System.out.println(n);
                break;
            }
            n++;
        }
    }
}
