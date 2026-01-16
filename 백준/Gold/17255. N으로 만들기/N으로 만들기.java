import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String n;
    static int count;
    static char[] arr;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        for(int i = 0 ; i < arr.length; i++){
            recur(i,i,""+arr[i],""+arr[i]);
        }
        System.out.println(set.size());
    }

    private static void recur(int left, int right, String ans, String path) {
        if(left == 0 && right == arr.length-1){
            set.add(path);
            return;
        }
        if(left - 1 >= 0){
            recur(left-1,right,arr[left-1]+ans, path+" "+arr[left]+ans);
        }
        if(right + 1 < arr.length){
            recur(left,right+1,ans+arr[right+1], path+" "+arr[right]+ans);
        }
    }
}