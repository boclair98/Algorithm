import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int n = word.length();

        //1부터 ~최솟 값 까지 완탐
        //다 방문 했으면 종료

        int start = 0;
        int idx = 0;
        while(true){
            start++;
            String temp = String.valueOf(start);
            for(int i = 0; i<temp.length(); i++){
                if(word.charAt(idx) == temp.charAt(i)){
                    idx++;
                }
                if(idx == n){
                    System.out.println(start);
                    return;
                }
            }

        }
    }
}
