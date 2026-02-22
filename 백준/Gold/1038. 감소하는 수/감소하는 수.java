import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n;
    static int[] arr;
    static List<Long> list = new ArrayList<>();
    static void back(long now, int cnt){
        if(cnt>10) return;
        list.add(now);
        for(int i = 0; i<now %10; i++){
            back(now*10+i,cnt+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if(n<10){
            System.out.println(n);
            return;
        }
        if(n>1022){
            System.out.println(-1);
            return;
        }
        for(int i = 0; i<10; i++){
            back(i,1);
        }
        Collections.sort(list);
        System.out.println(list.get(n));
    }
}