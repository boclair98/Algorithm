import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Map<String,List<String>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String group = br.readLine();
            int num = Integer.parseInt(br.readLine());
            map.put(group,new ArrayList<>());
            for(int j = 0; j < num; j++){
                String member = br.readLine();
                map.get(group).add(member);
            }
        }
        for(int i = 0; i<m; i++){
            String group = br.readLine();
            int number = Integer.parseInt(br.readLine());
            if(number == 0){
                //이름별 정렬
                map.get(group).sort((o1,o2) ->{
                    return o1.compareTo(o2);
                });
                for(String member : map.get(group)){
                    System.out.println(member);
                }
            }else{
                boolean found = false;
                for (String g :map.keySet()){
                    for (String s : map.get(g)) {
                        if(s.equals(group)){
                            System.out.println(g);
                            found = true;
                            break;
                        }
                    }
                    if(found)break;
                }
            }
        }
    }
}
