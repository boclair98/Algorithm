import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n;
    static List<Integer> list = new ArrayList<>();
    static boolean check(String str){
        if(str.length() == 0 || str.length() == 1) return true;
        int half = str.length()/2;
        for(int i = 1; i<=half; i++){
            String a = str.substring(str.length() -i * 2, str.length() - i);
            String z = str.substring(str.length() - i, str.length());
            if(a.equals(z)) return false;
        }
        return true;
    }
    static void recur(int idx, String answer){
        if(idx == n){
            System.out.println(answer);
            System.exit(0);
            return;
        }
        for(int i = 1; i <= 3; i++){
            if(check(answer + i) ) {
                recur(idx+1,answer + i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        recur(0,"");
    }
}