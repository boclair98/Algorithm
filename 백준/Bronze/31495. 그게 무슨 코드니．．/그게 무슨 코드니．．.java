import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if(s.charAt(0) == '\"' && s.charAt(s.length()-1) == '\"' && s.length()>2){
            System.out.println(s.substring(1, s.length()-1));
        }else{
            System.out.println("CE");
        }
    }
}
