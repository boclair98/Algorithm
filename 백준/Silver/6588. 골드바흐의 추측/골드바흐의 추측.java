import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,start,end;
    static boolean[] prime = new boolean[1000001];
    static void sosu(int num){
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; i*i<=num; i++){
            if(prime[i]){
                for(int j = i*i; j<=num; j+=i){
                    prime[j] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sosu(1000000);
        while(true){
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            start = 3;
            end = n - start;
            boolean flag = false;
            while(start<=end){
                if(prime[start] && prime[end]){
                    flag = true;
                    sb.append(n).append(" = ").append(start).append(" + ").append(end).append("\n");
                    break;
                }
                start+=2;
                end = n - start;

            }
            if(!flag){
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }
        System.out.println(sb.toString());

    }
}
