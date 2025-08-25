import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] map1;
    static int[][] map2;
    static boolean[][] visited;
    static int count = 0;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map1 = new int[5][5];
        map2 = new int[5][5];
        visited = new boolean[5][5];

        for(int i = 0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<5; j++){
                map1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<5; j++){
                map2[i][j]  = Integer.parseInt(st.nextToken());
                count++;
                for(int k = 0; k<5; k++){
                    for(int l = 0; l<5; l++){
                        if(map1[k][l] == map2[i][j]){
                            visited[k][l] = true;
                            break;
                        }
                    }
                }
                if(bingo()){
                    System.out.println(count);
                    return;
                }
            }
        }
    }
    static boolean bingo(){
        //행
        int total = 0;
        for(int i = 0; i<5; i++){
            boolean check = true;
            for(int j = 0; j<5; j++){
                if(!visited[i][j]){
                    check = false;
                    break;
                }
            }
            if(check){
                total++;
            }
        }

        //열
        for(int i = 0; i<5; i++){
            boolean check = true;
            for(int j = 0; j<5; j++){
                if(!visited[j][i]){
                    check = false;
                    break;
                }
            }
            if(check){
                total++;
            }
        }

        //대각선 위에서 아래
        boolean check = true;
        for(int i = 0; i<5; i++){
            if(!visited[i][i]){
                check = false;
                break;
            }
        }
        if(check){
            total++;
        }
        boolean checks = true;
        for(int i = 4; i>=0; i--){
            if(!visited[4-i][i]){
                checks = false;
                break;
            }
        }
        if(checks){
            total++;
        }

        return total>=3;
    }
}