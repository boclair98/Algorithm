import java.io.*;
import java.util.*;
import java.util.function.BiConsumer;

public class Main {
    static int n,max_val,min_val;
    static int[] count;
    static int[] number;
    static ArrayList<Integer> arr ;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        number = new int[n];
        max_val = -Integer.MAX_VALUE ;
        min_val = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        count = new int[4];
        st =  new StringTokenizer(br.readLine());
        for(int i = 0; i<4; i++){
            count[i] = Integer.parseInt(st.nextToken());
        }

        Backtracking(1,number[0]);
        System.out.println(max_val);
        System.out.println(min_val);

    }

    private static void Backtracking(int depth, int total) {

        if(depth == n){
            max_val = Math.max(total,max_val);
            min_val = Math.min(min_val,total);
            return;
        }

        for(int i = 0; i<4; i++){
            if(count[i] > 0 && i == 0){
                count[i]-=1;
                Backtracking(depth+1,total+number[depth]);
                count[i]++;
            }if(count[i]>0 && i == 1){
                count[i]-=1;
                Backtracking(depth+1,total-number[depth]);
                count[i]++;
            }if(count[i]>0 && i == 2){
                count[i]-=1;
                Backtracking(depth+1,total*number[depth]);
                count[i]++;
            }if(count[i]>0 && i == 3){
                count[i]-=1;
                Backtracking(depth+1,total/number[depth]);
                count[i]++;
            }

        }


    }
}
