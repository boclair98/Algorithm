import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int q1,q2,q3,q4,tr = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x == 0 || y == 0)tr++;
            if(x>0 && y>0) q1++;
            if(x<0 && y>0) q2++;
            if(x<0 && y<0) q3++;
            if(x>0 && y<0) q4++;
        }
        System.out.println("Q1: "+q1);
        System.out.println("Q2: "+q2);
        System.out.println("Q3: "+q3);
        System.out.println("Q4: "+q4);
        System.out.println("AXIS: "+tr);
    }
}
