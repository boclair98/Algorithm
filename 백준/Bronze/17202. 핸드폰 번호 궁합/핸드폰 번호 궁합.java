import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int count = 0;
        String number ="";
        for(int i = 0; i<a.length(); i++){
            number+=a.charAt(i);
            number+=b.charAt(i);
        }
        while(count < 14){
            String answer ="";
            for(int i = 0; i<number.length()-1; i++){
                int num1 = Integer.parseInt(String.valueOf(number.charAt(i)));
                int num2 = Integer.parseInt(String.valueOf(number.charAt(i+1)));
                int total = num1 + num2;
                if(total >= 10){
                    total = total % 10;
                }

                answer+=total;
            }
            number = answer;
            count++;
        }
        System.out.println(number);

    }
}