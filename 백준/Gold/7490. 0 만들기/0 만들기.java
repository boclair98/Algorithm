import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int t,n;
    static int[] arr;
    static String[] su = new String[]{" ","+","-"};
    static void backTracking(String answer){
        if(answer.length() == n-1){
            List<String> list = new ArrayList<>();
            String ans = "";
            int idx = 0;
            for(int i = 0; i < answer.length(); i++){
                ans+=arr[idx++];
                if(answer.charAt(i) != ' '){
                    list.add(ans);
                    list.add(String.valueOf(answer.charAt(i)));
                    ans ="";
                }
            }
            ans+=arr[idx];
            list.add(ans);
            int num  = -1;
            boolean first = false;
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).equals("+") && !first){
                    num = Integer.parseInt(list.get(i-1)) + Integer.parseInt(list.get(i+1));
                    first = true;
                }
                else if(list.get(i).equals("-") && !first){
                    num = Integer.parseInt(list.get(i-1)) - Integer.parseInt(list.get(i+1));
                    first = true;
                }
                else if(first && list.get(i).equals("+")){
                    num+=Integer.parseInt(list.get(i+1));
                }
                else if(first && list.get(i).equals("-")){
                    num-=Integer.parseInt(list.get(i+1));
                }
            }
            sb = new StringBuilder();
            if(num == 0){
                for (String s : list) {
                    if(s.length() == 1){
                        sb.append(s);
                    }else if(s.length() == 2){
                        sb.append(s.charAt(0)).append(" ").append(s.charAt(1));
                    }
                }
                System.out.println(sb);
            }
            return;

        }
        for(int i = 0; i < 3; i++){
            backTracking(answer+su[i]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while(t-->0){
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            for(int i = 1; i<=n; i++){
                arr[i-1] = i;
            }
            backTracking("");
            System.out.println();
        }

    }
}