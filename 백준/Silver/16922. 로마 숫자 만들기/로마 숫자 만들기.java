import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    static int n;
    static Set<Integer> set;
    static int num = 0;
    static int[] arr =new int[]{1,5,10,50};
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        BackTracking(0,0);
        System.out.println(set.size());
    }

    private static void BackTracking(int depth,int start) {
        if(depth == n){
            set.add(num);
            return;
        }
        for(int i = start; i< 4 ; i++){
            num+=arr[i];
            BackTracking(depth+1,i);
            num-=arr[i];
        }

    }

}