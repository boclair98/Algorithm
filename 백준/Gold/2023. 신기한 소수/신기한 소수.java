import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] number;
    static boolean[] visited;
    static List<Integer> num;
    static StringBuilder sb;
    static String[] first =new String[]{"2","3","5","7"};
    static String[] last = new String[]{"1","3","7","9"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new ArrayList<>();
        for(int i = 0; i<4; i++){
            DFS(first[i],1);
        }
    }

    private static void DFS(String num, int depth) {
        if(depth == n){
            System.out.println(num);
            return;
        }
        for(int i = 0; i<4; i++){
            String number  = num + last[i];
            if(sosu(Integer.parseInt(number))){
                DFS(number,depth+1);
            }

        }
    }

    private static boolean sosu(int number) {

        for(int i = 2; i<Math.sqrt(number); i++){
            if(number % i == 0)return false;
        }
        return true;
    }


}