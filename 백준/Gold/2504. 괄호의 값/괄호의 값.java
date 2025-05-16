import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String w = br.readLine();
        Stack<Character> stack = new Stack<>();
        int value = 1;
        int result = 0;

        for(int i = 0; i < w.length(); i++) {
            char m = w.charAt(i);
//            System.out.println(result);
            if(m == '(') {
                stack.push(m);
                value *= 2;
            } else if(m == '[') {
                stack.push(m);
                value *= 3;
            } else if(m == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }
                if(w.charAt(i-1) == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;
            } else if(m == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                if(w.charAt(i-1) == '[') {
                    result += value;
                }
                stack.pop();
                value /= 3;
            }
        }
        if(!stack.isEmpty()) {
            result = 0;
        }

        System.out.println(result);
    }
}
