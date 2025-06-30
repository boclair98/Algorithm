import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 2 * n ;
        for(int i = 1; i<=count/2; i++){
            for(int j = 0; j<n-i; j++){
                System.out.print(" ");
            }
            for(int j = 0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i =1; i<count/2; i++){
            for(int j = 0; j<i; j++){
                System.out.print(" ");
            }
            for(int j = 0; j<n-i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}