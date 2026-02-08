import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        String c = st.nextToken();
        int start = time(a);
        int end = time(b);
        int streaming = time(c);
        Map<String,Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            if(!st.hasMoreTokens()) break;
            String times = st.nextToken();
            String name = st.nextToken();
            if(time(times) <= start){
                map.put(name,time(times));
            }
            if(time(times)>=end && time(times)<=streaming){
                if(map.get(name) != null){
                    set.add(name);
                }
            }

        }
        System.out.println(set.size());
    }
    static int time(String ans){
        String[] s = ans.split(":");
        int a = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        return a;
    }
}