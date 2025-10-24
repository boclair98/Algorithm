import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int test,n,m,w;
    static List<int[]> list = new ArrayList<>();
    static int answer = -Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            list.add(new int[]{m,w});
        }
        Collections.sort(list,(o1,o2)->{
            return Integer.compare(o1[0],o2[0]);
        });
        int winner = 0;
        int max_price = 0;

        for(int i = 0; i < list.size(); i++){
            int count = 0;
            int price = list.get(i)[0];
            int bae  = list.get(i)[1];
            for(int j = 0; j< list.size(); j++){
                int next_price = list.get(j)[0];
                int next_bee = list.get(j)[1];
                if(next_price >=price && price >= next_bee){
                    count+=(price - next_bee);
                }
            }
            if(count > max_price){
                winner = price;
                max_price = count;
            }
        }
        System.out.println(winner);
    }
}
