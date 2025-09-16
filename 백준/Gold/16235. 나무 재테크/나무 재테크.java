import java.io.*;
import java.util.*;

public class Main {
    static int n,m,k;
    static int[][] yang;
    static List<Integer>[][] age;
    static int[][] bun;
    static boolean[][] visited;
    static int[] dx ={-1,-1,-1,0,0,1,1,1};
    static int[] dy ={-1,0,1,-1,1,-1,0,1};
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        age = new ArrayList[n][n];
        yang = new int[n][n];
        bun = new int[n][n];
        //초기값 양분 5
        for(int i = 0; i<n; i++){
            Arrays.fill(bun[i],5);
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                age[i][j] = new ArrayList<>();
            }
        }

        //map 설정
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                yang[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //나이 설정
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            age[x-1][m-1].add(z);

        }

        int start = 0;
        while(start < k){
            spring();
            fall();
            winter();
            start++;
        }
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                count+=age[i][j].size();
            }
        }
        System.out.println(count);

    }
    public static void spring(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(!age[i][j].isEmpty()){
                    Collections.sort(age[i][j]);
                    List<Integer> newTree = new ArrayList<>();
                    int dead = 0;
                    for(Integer s: age[i][j]){
                        if(bun[i][j]>=s){
                            bun[i][j]-=s;
                            newTree.add(s+1);
                        }else{
                            dead+=s/2;
                        }
                    }
                    age[i][j] = newTree;
                    bun[i][j] += dead;
                }
            }
        }
    }

    public static void winter(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                bun[i][j]+=yang[i][j];
            }
        }
    }

    public static void fall(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                for(int ages: age[i][j]){
                    if(ages % 5 == 0){
                        for(int k = 0; k<8; k++){
                            int nx = i+dx[k];
                            int ny = j+dy[k];
                            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                            age[nx][ny].add(1);
                        }
                    }
                }
            }
        }
    }
}
