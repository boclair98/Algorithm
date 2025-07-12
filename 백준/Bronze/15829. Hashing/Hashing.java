import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String input = br.readLine();
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i<alpha.length(); i++){
            String w = alpha.charAt(i)+"";
            map.put(w,i+1);
        }
//        System.out.println(map);
        long total = 0;
        long pow = 1;
        for(int i = 0; i<n; i++){
            total = (total + map.get(input.charAt(i)+"") * pow) % 1234567891;
            pow = (pow * 31 ) % 1234567891;
//            System.out.println(map.get(alpha.charAt(i)+""));
        }
        System.out.println(total);
    }
}