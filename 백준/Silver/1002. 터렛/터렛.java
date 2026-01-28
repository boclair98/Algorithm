import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int t;
    static int x1,y1,x2,y2,r1,r2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            int distance = (int) (Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
            if(x1 == x2 && y1 == y2 && r1 == r2) { 
                System.out.println(-1);
            } else if(distance > Math.pow(r1 + r2, 2)) { 
                System.out.println(0);
            } else if(distance < Math.pow(r2 - r1, 2)) { 
                System.out.println(0);
            } else if(distance == Math.pow(r2 - r1, 2)) { 
                System.out.println(1);
            } else if(distance == Math.pow(r1 + r2, 2)) {
                System.out.println(1);
            } else { 
                System.out.println(2);
            }
        }
    }
}