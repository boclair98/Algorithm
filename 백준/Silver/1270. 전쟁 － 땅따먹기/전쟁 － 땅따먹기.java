import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static Map<Long,Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            long count = Integer.parseInt(st.nextToken());
            map = new HashMap<>();
            boolean c = false;
            for(long j = 0; j<count; j++){
                long num = Long.parseLong(st.nextToken());
                map.put(num, map.getOrDefault(num,0)+1);
                if(map.get(num) > count / 2){
                    System.out.println(num);
                    c = true;
                    break;
                }
            }
            if(!c){
                System.out.println("SYJKGW");
            }
        }
    }

//    private static boolean check(int count,Map<Integer, Integer> map) {
//        for(Integer key : map.keySet()){
//            if(map.get(key) > count / 2){
//                return true;
//            }
//        }
//        return false;
//    }
}
