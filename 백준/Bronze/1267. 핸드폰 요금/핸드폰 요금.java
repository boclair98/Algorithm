import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int young = 0;
        int min = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            int num  = Integer.parseInt(st.nextToken());
            for(int j = 0; j<2; j++){
                if(j == 0) {
                    int div = num / 30;
                    int div2 = num % 30;
                    young+=(div*10);
                    if(div2 >= 0) young+=10;
                }else{
                    int div = num / 60;
                    int div2 = num % 60;
                    min+=(div*15);
                    if(div2 >= 0) min+=15;
                }
            }
        }
        if(young == min){
            System.out.println("Y M "+young);
        }else if(young < min){
            System.out.println("Y "+young);
        }else{
            System.out.println("M "+min);
        }
    }

}
