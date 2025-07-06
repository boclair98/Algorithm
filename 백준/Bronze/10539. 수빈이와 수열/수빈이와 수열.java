import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr =new int[t];
        int[] answer = new int[t];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < t; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for(int i = 0; i< t; i++){

           answer[i] = arr[i] *(i+1) - count;
           count+=answer[i];
           System.out.print(answer[i]+" ");
        }

    }
}