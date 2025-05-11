import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] size = new int[6];
        for(int i = 0; i<6; i++){
            size[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cloth = 0 ;
        for(int i = 0; i<6; i++){
            if(size[i] == 0){
                continue;
            }
            if(p >=size[i]){
                cloth++;
            }else{
                if(size[i] % p == 0){
                    cloth+=(size[i]/p);
                }else{
                    cloth+=(size[i]/p)+1;
                }
            }
        }
        System.out.println(cloth);
        int pen1 = n / k;
        int pen2 = n % k;
        System.out.print(pen1+" "+pen2);
    }
}
