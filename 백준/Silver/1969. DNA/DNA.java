import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static Character[] ch = new Character[]{'A','C','G','T'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String[] word = new String[n];
        int max_val = 0;
        for(int i = 0; i<n; i++){
            word[i] = br.readLine();
        }
        for(int i = 0; i<m; i++){
            Map<Character,Integer> map = new HashMap<>();
            List<String[]> al = new ArrayList<>();
            int max_count = 0;
            String chose = "";
            for(int j = 0; j<n; j++){
                map.put(word[j].charAt(i),map.getOrDefault(word[j].charAt(i),0)+1);
            }
            for (Character c : ch) {
                int cnt = map.getOrDefault(c,0);
                if(cnt > max_count){
                    max_count = map.get(c);
                    chose = String.valueOf(c);
                }
            }
            sb.append(chose);
        }
        String textAnswer =sb.toString();
        for(int i = 0; i<n; i++){
            String text = word[i];
            int count = 0;
            for(int j = 0; j<m; j++){
                if(textAnswer.charAt(j)!=text.charAt(j)){
                    count++;
                }
            }
            max_val+=count;
        }
        System.out.println(textAnswer);
        System.out.println(max_val);
    }

}
