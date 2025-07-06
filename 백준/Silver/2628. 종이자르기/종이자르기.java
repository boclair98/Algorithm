import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        x.add(0);x.add(n);
        y.add(0);y.add(m);
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == 0){
                y.add(b);
            }else{
                x.add(b);
            }
        }
        Collections.sort(x);
        Collections.sort(y);
        int max_x = 0;
        int max_y = 0;
        for(int i = 1; i<x.size(); i++){
            max_x = Math.max(max_x,x.get(i)-x.get(i-1));
        }
        for(int i = 1; i<y.size(); i++){
            max_y = Math.max(max_y,y.get(i)-y.get(i-1));
        }
        System.out.println(max_x*max_y);
        
    }
}