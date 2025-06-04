import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder word = new StringBuilder();

        boolean flag = false;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '<'){
                flag = true;
                sb1.append(word.reverse());
                word = new StringBuilder();
                sb1.append(c);
            }else if(c == '>'){
                flag = false;
                sb1.append(c);
            }else if(flag){
                sb1.append(c);
            }else {
                if(c == ' '){
                    sb1.append(word.reverse());
                    sb1.append(' ');
                    word = new StringBuilder();
                }else{
                    word.append(c);
                }
            }
        }
        sb1.append(word.reverse());
        System.out.println(sb1);
    }
}