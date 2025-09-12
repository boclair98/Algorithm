import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    static int n,m,total;
    static int[][] map;
    static int min_val ;
    static StringTokenizer st;
    static boolean[] visited;
    static ArrayList<Node> house;
    static ArrayList<Node> chicken;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        min_val = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    house.add(new Node(i, j));
                }else if(map[i][j] == 2){
                    chicken.add(new Node(i,j));
                }
            }
        }
        visited = new boolean[chicken.size()];
        DFS(0,0);
        System.out.println(min_val);
    }

    private static void DFS(int depth, int idx) {
        if(depth == m){
            total = 0 ;
            for(Node home: house){
                int minDistance = Integer.MAX_VALUE;
                for(int k = 0; k<chicken.size(); k++){
                    if(visited[k]) {
                        Node curr = chicken.get(k);
                        minDistance = Math.min(minDistance, (Math.abs(home.getX() - curr.getX())) + Math.abs(home.getY() - curr.getY()));
                    }
                }
                total+=minDistance;
            }
            min_val = Math.min(min_val,total);
            return;
        }
        for(int i = idx; i<chicken.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                DFS(depth+1,i+1);
                visited[i] = false;
            }
        }
    }

}
