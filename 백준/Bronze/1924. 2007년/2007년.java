import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int x,y;
    static Map<Integer,Integer> map = new HashMap<>();
    static String[] days = new String[]{"MON","TUE","WED","THU","FRI","SAT","SUN"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= 12; i++){
            if(i == 2) {
                map.put(i, 28);
            }
            if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12){
                map.put(i, 31);
            }
            if(i == 4 || i == 6 || i == 9 || i == 11){
                map.put(i, 30);
            }
        }
        int count = 0;
        int sx = 1;
        int sy = 1;
        while(true){
            if(sx == x && sy == y){
                break;
            }
            if(map.get(sx) > sy){
                sy++;
            }else{
                sx++;
                sy = 1;
            }
            count++;
        }

        System.out.println(days[(count)%7]);

    }
}
