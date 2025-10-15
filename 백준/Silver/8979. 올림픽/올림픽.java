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
        int count = 1;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0 ; i<n-1; i++){
            int r1 = list.get(i)[0];
            int g1 = list.get(i)[1];
            int s1 = list.get(i)[2];
            int b1 = list.get(i)[3];
            int r2 = list.get(i+1)[0];
            int g2 = list.get(i+1)[1];
            int s2 = list.get(i+1)[2];
            int b2 = list.get(i+1)[3];
            if(g1 == g2 && s1 == s2 && b1 == b2){
                q.add(new int[]{r1,g1,s1,b1,count});
                q.add(new int[]{r2,g2,s2,b2,count});
                count++;
                continue;
            }else{
                q.add(new int[]{r1,g1,s1,b1,count++});
                q.add(new int[]{r2,g2,s2,b2,count});
            }
        }
        for (int[] ints : q) {
//            System.out.println(ints[0]+" "+ints[4]);
            if(ints[0] == k){
                System.out.println(ints[4]);
                break;
            }
        }
    }



}
