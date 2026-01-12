import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split(" ");
        String s1 = word[0];
        String s2 = word[1];
        if(s1.length() == s2.length()) {
            int count = 0;
            for(int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }else{
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < s2.length()-s1.length()+1; i++){
                int count = 0;
                for(int j = 0; j < s1.length(); j++){
//                    System.out.println(s2.charAt(i+j)+" "+s1.charAt(j));
                    if(s2.charAt(i+j) != s1.charAt(j)) {
                        count++;
                    }
                }
                min = Math.min(min, count);
            }
            System.out.println(min);
        }
    }

}
