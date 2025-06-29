import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<7; i++){
            int num = Integer.parseInt(br.readLine());
            if(num%2 == 1){
                list.add(num);
                sum+=num;
            }
        }
        if(sum == 0){
            System.out.println(-1);
        }else{
            System.out.println(sum);
            Collections.sort(list);
            System.out.println(list.get(0));
        }

    }
}