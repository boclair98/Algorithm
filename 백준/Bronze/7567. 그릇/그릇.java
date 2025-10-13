import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] dish = br.readLine().toCharArray();
        int height = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<dish.length; i++){
           if(stack.isEmpty()){
               height+=10;
               stack.push(dish[i]);
           }else if(stack.peek() == dish[i]){
               height+=5;
               stack.push(dish[i]);
           }else{
               height+=10;
               stack.push(dish[i]);
           }
        }
        System.out.println(height);

    }

}
