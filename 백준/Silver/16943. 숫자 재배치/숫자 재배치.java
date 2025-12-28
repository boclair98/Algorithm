import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long n,num;
    static boolean[] visited;
    static char[] s;
    static List<Character> list = new ArrayList<>();
    static List<Long> l = new ArrayList<>();
    static long max_num = 0;
    static void recur(int idx){
        if(idx == n){
            String s ="";
            for (Character c : list) {
                s+=String.valueOf(c);
            }
            if(s.charAt(0) == '0') return;
            long se = Long.parseLong(s);
            if(se < num){
                max_num = Math.max(max_num,se);
            }
            return;
        }
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(s[i]);
                recur(idx+1);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        s = st.nextToken().toCharArray();
        num = Long.parseLong(st.nextToken());
        n = s.length;
        visited = new boolean[(int)n];
//        if(s.length != String.valueOf(num).length()){
//            System.out.println(-1);
//            return;
//        }
        recur(0);
        if(max_num == 0){
            System.out.println(-1);
        }else{
            System.out.println(max_num);
        }
    }
}