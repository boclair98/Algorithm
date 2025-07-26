import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i<3; i++){
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<4; j++){
                count+=Integer.parseInt(st.nextToken());
            }
            if(count == 0){
                System.out.println("D");
            }else if(count == 1){
                System.out.println("C");
            }else if(count == 2){
                System.out.println("B");
            }else if(count == 3){
                System.out.println("A");
            }else{
                System.out.println("E");
            }
        }
    }

    }

