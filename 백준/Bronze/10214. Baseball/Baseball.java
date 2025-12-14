import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int y = 0;
            int k = 0;
            for(int i = 0; i<9; i++){
                st = new StringTokenizer(br.readLine());
                y+=Integer.parseInt(st.nextToken());
                k+=Integer.parseInt(st.nextToken());
            }
            if(y>k){
                System.out.println("Yonsei");
            }else if(y<k){
                System.out.println("Korea");
            }else{
                System.out.println("Draw");
            }
        }
    }
}

