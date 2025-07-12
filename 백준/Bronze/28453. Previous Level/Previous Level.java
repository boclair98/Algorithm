import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num==300){
                System.out.print(1+" ");
            }else if(num>=275){
                System.out.print(2+" ");
            }else if(num>=250){
                System.out.print(3+" ");
            }else{
                System.out.print(4+" ");
            }
        }
    }
}