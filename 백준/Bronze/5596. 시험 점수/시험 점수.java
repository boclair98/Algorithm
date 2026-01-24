import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum1 = 0;
        int sum2 = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            sum1+=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            sum2+=Integer.parseInt(st.nextToken());
        }
        if(sum1 >= sum2){
            System.out.println(sum1);
        }else if(sum1 < sum2){
            System.out.println(sum2);
        }
        
    }
}