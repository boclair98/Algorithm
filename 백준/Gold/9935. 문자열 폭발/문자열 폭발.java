import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String word2 = br.readLine();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<word.length(); i++){
            stack.push(word.charAt(i));
            if(stack.size() >= word2.length()){
                boolean check = true;
                for(int j = word2.length()-1; j>=0; j--){
                    if(word2.charAt(j) != stack.get(stack.size()-word2.length()+j )){
                        check = false;
                        break;
                    }
                }
                if(check){
                    for(int j = 0; j<word2.length(); j++){
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()){
            System.out.println("FRULA");
        }else{
            for (Character c : stack) {
                sb.append(c);
            }
            System.out.println(sb);
        }

    }

}
