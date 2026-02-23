import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String word;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        for(int i = 2; i < word.length(); i++) {
            for(int j = 1 ; j < i; j++) {
                StringBuilder s = new StringBuilder(word.substring(0,j));
                StringBuilder t = new StringBuilder(word.substring(j,i));
                StringBuilder k = new StringBuilder(word.substring(i));
                String last_word = s.reverse().toString() + t.reverse().toString() + k.reverse().toString();
                list.add(last_word);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }

}
