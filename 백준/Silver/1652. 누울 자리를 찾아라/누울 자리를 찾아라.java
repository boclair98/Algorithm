import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int width_count = 0;
        int height_count = 0;
        char[][] map = new char[n][n];

        for(int i = 0; i<n; i++){
            String word = br.readLine();
            for(int j = 0; j < n ; j++){
                map[i][j] = word.charAt(j);
            }
        }

        // 가로
        for(int i = 0; i<n; i++){
            int width = 0;
            for(int j = 0; j<n; j++){
                if(map[i][j]=='.'){
                    width++;
                }else if(map[i][j]=='X'){
                    if(width>=2){
                        width_count++;
                    }
                    width = 0;

                }
            }
            if(width >=2){
                width_count++;
            }

        }

        //세로
        for(int i = 0; i<n; i++){
            int height = 0;
            for(int j = 0; j<n; j++){
                if(map[j][i]=='.'){
                    height++;
                }else if(map[j][i]=='X'){
                    if(height >= 2){
                        height_count++;
                        
                    }
                    height = 0;

                }
            }
            if(height>=2){
                height_count++;
            }

        }
        System.out.println(width_count+" "+height_count);
    }


}