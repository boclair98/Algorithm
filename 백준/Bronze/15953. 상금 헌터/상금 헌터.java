import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i<t; i++){
            int money = 0;
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(a <=1  && a > 0){
                money+=5000000;
            }else if( a<=3 && a > 0){
                money+=3000000;
            }else if(a<=6 && a > 0){
                money+=2000000;
            }else if(a<=10 && a > 0){
                money+=500000;
            }else if(a<=15 && a > 0){
                money+=300000;
            }else if(a<=21 && a > 0){
                money+=100000;
            }

            if(b <=1 && b > 0){
                money+=5120000;
            }else if (b<=3 && b > 0){
                money+=2560000;
            }else if(b<=7 && b > 0){
                money+=1280000;
            }else if(b<=15 && b > 0){
                money+=640000;
            }else if(b<=31 && b > 0){
                money+=320000;
            }
            System.out.println(money);
        }
    }
}