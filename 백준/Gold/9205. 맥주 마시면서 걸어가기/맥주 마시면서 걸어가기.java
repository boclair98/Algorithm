import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int t,n;
    static int[][] maps;
    static Point[] points;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[] visited;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int i = 0; i<t; i++){
            n = Integer.parseInt(br.readLine());
            points = new Point[n+2];
            st = new StringTokenizer(br.readLine());
            points[0] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            for(int j = 1; j<=n; j++){
                st = new StringTokenizer(br.readLine());
                points[j] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            points[n+1] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            if(bfs()){
                System.out.println("happy");
            }else{
                System.out.println("sad");
            }
        }
    }

    private static boolean bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited = new boolean[n+2];
        visited[0] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            if (n+1 == cur){
                return true;
            }
            for(int next = 0; next < n + 2; next++){
                if(!visited[next] && dist(points[cur], points[next]) <=1000){
                    visited[next] = true;
                    q.add(next);
                }
            }

        }
        return false;
    }
    private static int dist(Point x,Point y){
        return Math.abs(x.x - y.x) + Math.abs(x.y - y.y);

    }


}

