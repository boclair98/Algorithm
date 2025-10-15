import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new int[]{num,gold,silver,bronze});
        }
        list.sort((o1,o2) ->{
            if(o1[1] != o2[1]){
                return Integer.compare(o2[1],o1[1]);
            }else if(o1[2] !=o2[2]){
                return Integer.compare(o2[2],o1[2]);
            }
            return Integer.compare(o2[3],o1[3]);
        });
        int[] rank = new int[n+1];
        rank[0] = 1;
        for(int i = 1 ; i<n; i++) {
            int[] f = list.get(i-1);
            int[] e = list.get(i);
            if(f[1] == e[1] && f[2] == e[2] && f[3] == e[3]){
                rank[i] = rank[i-1];
            }else{
                rank[i] = i+1;
            }
        }
        for(int i = 0; i<n; i++){
            if(list.get(i)[0] == k){
                System.out.println(rank[i]);
                break;
            }
        }
    }



}
