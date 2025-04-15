import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String number ="";
        int count = 0;
        int start = 1;
        while(start<=n){
            if(start<10){
                count++;
            }else if(start<100){
                count+=2;
            }else if(start<1000){
                count+=3;
            }else if(start<10000){
                count+=4;
            }else if(start<100000){
                count+=5;
            }else if(start<1000000){
                count+=6;
            }else if(start<10000000){
                count+=7;
            }else if(start<100000000){
                count+=8;
            }else{
                count+=9;
            }
            start++;
        }
        System.out.println(count);
    }
}