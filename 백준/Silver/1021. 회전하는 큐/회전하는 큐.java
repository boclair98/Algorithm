import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> link = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            link.add(i);
        }

        for(int i = 0; i<m; i++){
            int a = Integer.parseInt(st.nextToken());
            if(link.peek() == a){
                link.poll();
                continue;
            }
            if(link.indexOf(a) <= link.size() /2){
                while (true){
                    if(link.peek() == a){
                        link.poll();
                        break;
                    }
                    link.add(link.poll());
                    count++;
                }
            }else{
                while (true){
                    if(link.peek() == a){
                        link.poll();
                        break;
                    }
                    link.addFirst(link.remove(link.size()-1));
                    count++;
                }
            }
        }
//        System.out.println(link);
        System.out.println(count);
    }
}

