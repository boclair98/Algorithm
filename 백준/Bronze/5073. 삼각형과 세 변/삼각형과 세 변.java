import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[] arr = new int[3];
            arr[0] = a;
            arr[1] = b;
            arr[2] = c;
            Arrays.sort(arr);
            if(a == 0 && b == 0 && c == 0) break;
            if(arr[0]+arr[1] <= arr[2]){
                System.out.println("Invalid");
            }else{
                if(a == b && b == c){
                    System.out.println("Equilateral");
                }else if(a != b && b!=c && a != c){
                    System.out.println("Scalene");
                }else{
                    System.out.println("Isosceles");
                }
            }
        }

    }
}
