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
        Map<String,String> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            String[] words = br.readLine().split(" ");
            map.put(words[0],words[1]);
        }
        for(int i = 0; i<m; i++){
            String answer = br.readLine();
            sb.append(map.get(answer)).append("\n");
        }
        System.out.println(sb);


    }


}
