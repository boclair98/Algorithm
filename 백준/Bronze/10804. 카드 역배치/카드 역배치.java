import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<=20; i++){
            list.add(i);
        }
        for(int i = 0; i<10; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int[] arr = new int[21];
            for(int j = num1-1; j<num2; j++){
                arr[j] = list.get(j);
            }
            int start = num2 - 1;
            int idx = num1-1;
            while(idx < num2){
                list.set(idx,arr[start]);
                idx++;
                start--;
            }

        }
        for (Integer i : list) {
            System.out.print(i+" ");
        }
    }

}
