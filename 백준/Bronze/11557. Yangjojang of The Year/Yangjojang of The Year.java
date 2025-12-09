import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(n-->0){
            int num = Integer.parseInt(br.readLine());
            String sc ="";
            int max_val = 0;
            for(int i=0; i<num; i++){
                String[] word = br.readLine().split(" ");
                if(Integer.parseInt(word[1])>max_val){
                    sc = word[0];
                    max_val = Integer.parseInt(word[1]);
                }
            }
            System.out.println(sc);
        }
    }
}

