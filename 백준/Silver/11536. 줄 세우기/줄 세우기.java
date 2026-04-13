import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        List<String> name = new ArrayList<>();
        String[] names = new String[n];
        for(int i = 0; i < n; i++){
            names[i] = br.readLine();
            name.add(names[i]);
        }
        Collections.sort(name);
        boolean check = true;
        for(int i = 0; i < n; i++){
            if(!(names[i].equals(name.get(i)))){
                check = false;
            }
        }
        if(check){
            System.out.println("INCREASING");
            return;
        }
        Collections.sort(name,Collections.reverseOrder());
        boolean checks = true;
        for(int i = 0; i < n; i++){
            if(!(names[i].equals(name.get(i)))){
                checks = false;
            }
        }
        if(checks){
            System.out.println("DECREASING");
            return;
        }
        System.out.println("NEITHER");

    }
}

