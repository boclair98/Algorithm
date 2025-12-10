import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
        int count = 1;
        while(true){
            int num = Integer.parseInt(br.readLine());
            if(num == 0) break;
            int num1 = num * 3;
            int num2 = 0;
            if(num1 % 2 == 0){
                num2 = num1 / 2;
            }else if(num1 % 2 == 1){
                num2 = (num1 + 1) /2;
            }
            int num3 = 3 * num2;
            int num4 = num3 / 9;
            if(num1 % 2 == 0){
                System.out.println(count+". even "+ (num4));
            }else if(num1 % 2 == 1){
                System.out.println(count+". odd "+ (num4));
            }
            count++;
        }
    }
}

