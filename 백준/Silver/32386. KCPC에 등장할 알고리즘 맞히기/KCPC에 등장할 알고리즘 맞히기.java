import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static Map<String,Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                String c = st.nextToken();
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        int max = 0;
        for(String s : map.keySet()){
            max = Math.max(max,map.get(s));
        }
        int total = 0;
        for(String s : map.keySet()){
            if(map.get(s) == max){
                sb.append(s);
                total++;
            }
        }
        if(total > 1){
            System.out.println(-1);
        }else{
            System.out.println(sb);
        }


    }
}

