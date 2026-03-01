import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            Long num = Long.parseLong(br.readLine());
            int cnt = 0;
            while(num > 1){
                 if(num % 2 == 1 ) cnt++;
                 num = (num + 1) / 2;
            }
            System.out.println(cnt);
        }
    }
}
