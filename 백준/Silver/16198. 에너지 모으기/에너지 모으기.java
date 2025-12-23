import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static List<Integer> list = new ArrayList<>();
    static int max_val = 0;
    static void recur(int count){
        if(list.size() == 2){
            max_val = Math.max(max_val,count);
            return;
        }
        for(int i = 1; i<list.size()-1; i++){
            int num = list.get(i);
            int w = list.get(i-1) * list.get(i+1);
            list.remove(i);
            recur(count+w);
            list.add(i,num);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        recur(0);
        System.out.println(max_val);

    }
}