import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,t;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        int goal = sum - 100;
        int x = -1;
        int y = -1;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if(arr[i] + arr[j] == goal) {
                    x = i;
                    y = j;
                }
            }
        }
        for(int i = 0; i < 9; i++) {
            if(i == x || y == i) continue;
            System.out.println(arr[i]);
        }
    }

}
