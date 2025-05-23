import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Character[] alpha = {'a','e','i','o','u'};
        while(true){
            String word = br.readLine();
            if(word.equals("end")){
                break;
            }
            if(check(word,alpha) && check2(word,alpha) && check3(word,alpha)){
                System.out.println("<"+word+">"+ " is acceptable.");
            }else{
                System.out.println("<"+word+">"+ " is not acceptable.");
            }

        }
    }
    static boolean check(String word,Character[] alpha){
        int count = 0;
        for(int i = 0; i<word.length(); i++){
            for(int j = 0; j<alpha.length; j++){
                if(word.charAt(i) == alpha[j]){
                    count++;
                }
            }
        }
        if(count > 0){
            return true;
        }
        return false;
    }
    static boolean check2(String word,Character[] alpha){
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i<word.length(); i++) {
            char w = word.charAt(i);
            boolean checks = false;
            for (int j = 0; j < alpha.length; j++) {
                if (w == alpha[j]) {
                    checks = true;
                }
            }
            if (checks) {
                count2 = 0;
                count1++;
            } else {
                count2++;
                count1 = 0;
            }
            if (count1 >= 3 || count2 >= 3) {
                return false;
            }
        }
        return true;
    }

    static boolean check3(String word,Character[] alpha){
        for(int i = 0; i<word.length()-1; i++){
            if(word.charAt(i) == 'e' || word.charAt(i) =='o'){
                continue;
            }else if(word.charAt(i) == word.charAt(i+1)){
                return false;
            }
        }
        return true;
    }
}
