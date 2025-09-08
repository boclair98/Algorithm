import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        List<String> col = new ArrayList<>();
        for(int i = 0; i<word.length(); i++){
            String answer = "";
            for(int j = i; j<word.length(); j++){
                answer += word.charAt(j);
            }
            col.add(answer);
        }
        Collections.sort(col);
        for(String name : col){
            System.out.println(name);
        }


    }



}

