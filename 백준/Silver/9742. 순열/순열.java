import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String str;
    static Integer num;
    static boolean[] visited;
    static char[] chars;
    static int total = 0;
    static String s ="";
    static void recur(int cnt, String str){
        if(cnt == str.length()){
            total++;
            if(total == num){
                s = new String(chars);
            }
            return;
        }
        for(int i = 0; i<str.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                chars[cnt] = str.charAt(i);
                recur(cnt+1,str);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            st = new StringTokenizer(line);
            str = st.nextToken();
            total = 0;
            num = Integer.parseInt(st.nextToken());
            visited = new boolean[str.length()];
            chars = new char[str.length()];
            recur(0,str);
            if(total < num){
                System.out.println(str+" "+num+" = "+"No permutation");
            }else{
                System.out.println(str+" "+num+" = "+s);
            }
        }
    }
}