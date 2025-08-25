import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] total = new int[n][m];
        for(int i = 0; i<n; i++){
            Arrays.fill(total[i], -1);
        }
        //초기 c 모음
        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        char[][] maps = new char[n][m];
        for(int i = 0; i < n; i++){
            String word = br.readLine();
            for(int j = 0; j < m; j++){
                maps[i][j] = word.charAt(j);
                if(maps[i][j] =='c'){
                    q1.offer(new int[]{i,j});
                    q2.offer(new int[]{i,j,0});
                }
            }
        }
        while(!q2.isEmpty()){
            int[] cur = q2.poll();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];
            if(y + 1 >= m) continue;
            int ny = y + 1;
            if(maps[x][ny] == 'c') continue;
            if(maps[x][ny] == '.'){
                q2.offer(new int[]{x,ny,time+1});
                total[x][ny] = time+1;
            }
        }

        while(!q1.isEmpty()){
            int[] cur = q1.poll();
            total[cur[0]][cur[1]] = 0;
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.print(total[i][j]+" ");
            }
            System.out.println();
        }

    }

}

