import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int zero = 0;
        int two = 0;
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                zero++;
            }else{
                two++;
            }
        }
        if(zero > two){
            System.out.println("Junhee is not cute!");
        }else{
            System.out.println("Junhee is cute!");
        }
    }
}

