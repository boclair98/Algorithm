import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;
        char[] word = br.readLine().toCharArray();
        for(int i = 0; i < word.length; i++) {
            if(word[i] == 'A') {
                a++;
            }else if(word[i] == 'B') {
                b++;
            }
        }
        if(a > b){
            System.out.println('A');
        }else if(b > a){
            System.out.println('B');
        }else{
            System.out.println("Tie");
        }
    }
}

