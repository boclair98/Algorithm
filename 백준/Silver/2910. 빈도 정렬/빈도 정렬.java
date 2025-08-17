import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            map.put(num,map.getOrDefault(num,0)+1);
            list.add(num);
        }
        List<Integer> number = new ArrayList<>();
        for (Integer i : map.keySet()) {
            number.add(i);
        }
        number.sort((o1, o2) -> {
            if (!map.get(o1).equals(map.get(o2))) return map.get(o2) - map.get(o1); // 빈도 내림차순
            return list.indexOf(o1) - list.indexOf(o2); // 빈도가 같으면 먼저 등장한 순서
        });
//        System.out.println(number);
        for(int i = 0; i< number.size(); i++){
            int num = number.get(i);
            int score = map.get(num);
            for(int j = 0; j<score; j++){
                System.out.print(num+" ");
            }
        }


    }

}
