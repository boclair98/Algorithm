import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int total = 0;
        for(int i = 1; i<=n; i++){
            String number = String.valueOf(i);
            if(number.length() == 1){
                total++;
            }else if (number.length() == 2){
                total++;
            }else{
                int num = Integer.parseInt(number.substring(1,2)) - Integer.parseInt(number.substring(0,1));
                int num2 = Integer.parseInt(number.substring(2,3)) - Integer.parseInt(number.substring(1,2));
                if(num == num2){
                    total++;
                }
            }
        }
        System.out.println(total);
    }
}
