import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 2 == 7

public class Main {
    static BufferedReader br ;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;
        char[] one = new char[8];
        char[] two = new char[8];
        char[] three = new char[8];
        char[] four= new char[8];
        makes(one);
        makes(two);
        makes(three);
        makes(four);
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int aa = 0, bb = 0, cc = 0, dd = 0;
            if(num == 1){
                aa = dir;
                if(one[2] !=two[6]){
                    bb = -aa;
                }
                if(bb!=0 && two[2]!=three[6]){
                    cc = -bb;
                }
                if(cc!=0 && three[2]!=four[6]){
                    dd = -cc;
                }
                moves(one,aa);
                if(bb!=0){
                    moves(two,bb);
                }
                if(cc!=0){
                    moves(three,cc);
                }
                if(dd!=0){
                    moves(four,dd);
                }

            }
            if(num == 2){
                bb = dir;
                if(two[6]!=one[2]){
                    aa = -bb;
                }
                if(two[2]!=three[6]){
                    cc = - bb;
                }
                if(cc!=0){
                    if(three[2]!=four[6]){
                        dd = - cc;
                    }
                }
                moves(two,bb);
                if(aa!=0){
                    moves(one,aa);
                }
                if(cc!=0){
                    moves(three,cc);
                }
                if(dd!=0){
                    moves(four,dd);
                }
            }
            if(num == 3){
                cc = dir;
                if(three[6]!=two[2]){
                    bb = -cc;
                }
                if(three[2]!=four[6]){
                    dd = -cc;
                }
                if(bb!=0){
                    if(one[2]!=two[6]){
                        aa = -bb;
                    }
                }
                moves(three,cc);
                if(aa!=0){
                    moves(one,aa);
                }
                if(bb!=0){
                    moves(two,bb);
                }
                if(dd!=0){
                    moves(four,dd);
                }
            }
            if(num == 4){
                dd = dir;
                if(four[6]!=three[2]){
                    cc = -dd;
                }
                if(cc!=0){
                    if(two[2]!=three[6]){
                        bb = -cc;
                    }
                }
                if(bb!=0){
                    if(one[2]!=two[6]){
                        aa = -bb;
                    }
                }
                moves(four,dd);
                if(aa!=0){
                    moves(one,aa);
                }
                if(cc!=0){
                    moves(three,cc);
                }
                if(bb!=0){
                    moves(two,bb);
                }
            }
        }
        if(one[0] == '1'){
            total+=1;
        }
        if(two[0] == '1'){
            total+=2;
        }
        if(three[0] == '1'){
            total+=4;
        }
        if(four[0] == '1'){
            total+=8;
        }
        System.out.println(total);


    }
    private static void makes(char[] c) throws IOException {
        String s = br.readLine();
        for(int i = 0; i<s.length(); i++){
            c[i] = s.charAt(i);
        }
    }
    private static void moves(char[] c, int dir) {
        if (dir == 1) { // 시계 방향 회전
            char last = c[c.length - 1];
            for (int i = c.length - 1; i > 0; i--) {
                c[i] = c[i - 1];
            }
            c[0] = last;
        } else if (dir == -1) { // 반시계 방향 회전
            char first = c[0];
            for (int i = 0; i < c.length - 1; i++) {
                c[i] = c[i + 1];
            }
            c[c.length - 1] = first;
        }
    }

}

