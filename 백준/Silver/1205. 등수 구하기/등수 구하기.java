import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        if(n == 0){
            System.out.println(1);
            return;
        }
        Long score = Long.parseLong(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        List<Long> num = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            num.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(num,Collections.reverseOrder());
        int rank = 1;
        for(int i = 0; i<num.size(); i++){
            if(score < num.get(i)){
                rank++;
            }else{
                break;
            }
        }

        if(n == p && score <= num.get(num.size()-1)){
            System.out.println(-1);
        }else{
            System.out.println(rank);
        }


    }
}
