import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int init_num = -1;
    static int n;
    static String[] num = new String[10];
    static boolean[] visited = new boolean[10];
    static boolean[] check = new boolean[1000010];
    static List<Integer> list = new ArrayList<>();
    static void recur(int idx){
        if(idx == n){
            sb = new StringBuilder();
            for (Integer i : list) {
                sb.append(i);
            }
            int number = Integer.parseInt(sb.toString());
            if(number > init_num){
                check[number] = true;
            }

            return;
        }
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(Integer.parseInt(num[i]));
                recur(idx+1);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = s.length();
        init_num = Integer.parseInt(s);
        for(int i = 0; i<s.length(); i++){
            num[i] = String.valueOf(s.charAt(i));
        }
        check[init_num] = true;
        recur(0);
        for(int i = init_num+1; i<=999999; i++){
            if(check[i]){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}