import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<n; i++){
            int count = 0;
           StringTokenizer st = new StringTokenizer(br.readLine());
           int number = Integer.parseInt(st.nextToken());
           List<Integer> human = new ArrayList<>();
           for(int j = 0; j<20; j++){
               human.add(Integer.parseInt(st.nextToken()));
           }
           while (true){
               if(check(human)) break;
               for(int k = 0; k<19; k++){
                   if(human.get(k) > human.get(k+1)){
                       int temp1 = human.get(k);
                       int temp2 = human.get(k+1);
                       human.set(k,temp2);
                       human.set(k+1,temp1);
                       count++;
                   }
               }
           }
            System.out.println(number+" "+count);

        }
    }
    public static boolean check(List<Integer> human){
        for(int i = 0; i< human.size()-1; i++){
            if(human.get(i) > human.get(i+1)) return false;
        }
        return true;
    }
}
