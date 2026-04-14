import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,d,count;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        int max_val = 0;
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
            max_val = Math.max(max_val,num[i]);
        }
        int diff = max_val - d;
        if(diff < 0){
            diff = 0;
        }
        long height = 0;
        for(int i = 0; i < n; i++){
            if(num[i] > diff){
                height+= num[i]- diff;
            }
        }
        System.out.println(height);



    }
}

