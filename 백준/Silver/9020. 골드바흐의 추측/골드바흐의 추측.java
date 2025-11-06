import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean sosu(int num){
        if( num < 2) return false;
        for(int i = 2; i*i<=num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            int number = Integer.parseInt(br.readLine());
            int a = number / 2;
            int b = number / 2;
            while(true){
                if(sosu(a) && sosu(b)) {
                    System.out.println(a + " " + b);
                    break;
                }else{
                    a--;
                    b++;
                }
            }
        }

    }
}
