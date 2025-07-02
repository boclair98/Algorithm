import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();
        int total = 0;
        boolean check = false;
        for(int i = 0; i<word.length; i++){
            if(word[i] == '*'){
                if(i%2 == 1){
                    check = true;
                }
                continue;
            }
            if(i%2 == 0){
                total+=Integer.parseInt(String.valueOf(word[i]));
            }else{
                total+=Integer.parseInt(String.valueOf(word[i]))*3;
            }
        }
        if(check){
            for(int i = 0; i<10; i++){
                if(((total+(i*3)) % 10 == 0)){
                    System.out.println(i);
                    break;
                }
            }
        }else{
            System.out.println(10-total%10);
        }

    }
}