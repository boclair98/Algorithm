import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
//        Map<String,Integer> map = new HashMap<>();
        Set<String> list = new LinkedHashSet<>();
        for(int i = 0; i < m; i++){
            String num = br.readLine();
//            map.put(num, map.getOrDefault(num, 0) + 1);
            if(list.contains(num)){
                list.remove(num);
            }
            list.add(num);
        }
        for (String s : list) {
            if(n > 0){
                sb.append(s).append("\n");
                n--;
            }
        }
        System.out.println(sb);
    }


}
