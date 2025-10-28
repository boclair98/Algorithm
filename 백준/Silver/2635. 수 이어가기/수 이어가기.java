import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int num,max_val;
    static List<Integer> number = new ArrayList<>();
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        int idx =num;
        while(idx > 0){
            list = new ArrayList<>();
            list.add(num);
            for(int i = idx; i>=0; i--){
                list.add(i);
                while(true){
                    int num = list.size()-1;
                    if(list.get(num-1) - list.get(num) >=0 ){
                        list.add(list.get(num-1) - list.get(num));
                    }else{
                        break;
                    }
                }
                break;
            }
            idx--;
            if(list.size() >= max_val){
                max_val = list.size();
                number = list;
            }
        }
        System.out.println(max_val);
        for (Integer i : number) {
            System.out.print(i+" ");
        }
    }

}
