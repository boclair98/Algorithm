import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n, count;
    static List<Integer> list = new ArrayList<>();

    static void back(int idx){
        if(idx == n){
            sb = new StringBuilder();
            for (Integer i : list) {
                sb.append(i);
            }
            String ans = sb.toString();
            if(ans.charAt(0) == '0') return;
            int num = Integer.parseInt(ans);
            if(num % 3 == 0) count++;
            return;
        }
        for(int i = 0; i<3; i++){
            list.add(i);
            back(idx+1);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        back(0);
        System.out.println(count);
    }
}