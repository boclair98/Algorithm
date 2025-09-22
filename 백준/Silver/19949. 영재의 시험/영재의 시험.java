import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int count = 0;
    static int[] arr = new int[10];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<10; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int idx) {
        if(idx == 10){
//            System.out.println(list);
            int total = 0;
            for(int i = 0; i<10; i++){
                if(arr[i] == list.get(i)){
                    total++;
                }
            }
            if(total >=5){
                count++;
            }
            return;
        }
        for(int i = 1; i<=5; i++){
            list.add(i);
            if(check()){
                dfs(idx+1);
            }
            list.remove(list.size()-1);
        }

    }
    static boolean check(){
        for(int i = 0; i<list.size()-2; i++){
            if(list.get(i) == list.get(i+1) && list.get(i+1)==list.get(i+2)){
                return false;
            }
        }
        return true;
    }
}
