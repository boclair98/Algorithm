import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for(int i = 0 ; i < n; i++){
            String s = br.readLine();
            for(int j = 0 ; j < n ; j++){
                map[i][j] = s.charAt(j);
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] == 'M'){
                    //case 8개 대각선 상하좌우
                    if(i - 4 >= 0){
                        if(map[i-1][j] == 'O' && map[i-2][j] =='B' && map[i-3][j] == 'I' && map[i-4][j] == 'S'){
                            count++;
                        }
                    }
                    if(i - 4 >= 0 && j + 4 < n ){
                        if(map[i-1][j+1] == 'O' && map[i-2][j+2] =='B' && map[i-3][j+3] == 'I' && map[i-4][j+4] == 'S'){
                            count++;
                        }
                    }
                    if(j + 4 < n){
                        if(map[i][j+1] == 'O' && map[i][j+2] =='B' && map[i][j+3] == 'I' && map[i][j+4] == 'S'){
                            count++;
                        }
                    }
                    if(i+4 < n && j + 4 < n){
                        if(map[i+1][j+1] == 'O' && map[i+2][j+2] =='B' && map[i+3][j+3] == 'I' && map[i+4][j+4] == 'S'){
                            count++;
                        }
                    }
                    if(i + 4 < n){
                        if(map[i+1][j] == 'O' && map[i+2][j] =='B' && map[i+3][j] == 'I' && map[i+4][j] == 'S'){
                            count++;
                        }
                    }
                    if(i+4 < n && j-4>=0){
                        if(map[i+1][j-1] == 'O' && map[i+2][j-2] =='B' && map[i+3][j-3] == 'I' && map[i+4][j-4] == 'S'){
                            count++;
                        }
                    }
                    if(j-4>=0){
                        if(map[i][j-1] == 'O' && map[i][j-2] =='B' && map[i][j-3] == 'I' && map[i][j-4] == 'S'){
                            count++;
                        }
                    }
                    if(i-4 >= 0 && j - 4 >= 0){
                        if(map[i-1][j-1] == 'O' && map[i-2][j-2] =='B' && map[i-3][j-3] == 'I' && map[i-4][j-4] == 'S'){
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

}
