import java.util.*;
class Solution {
    //방문처리 
    static boolean[][] visited;
    //2차원 변환
    static String[][] map;
    static int n,m;
    static int total;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    public List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        map = new String[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                map[i][j] = maps[i].charAt(j)+"";
            }
        }
        
        
        //우선 문자열이 숫자이고 방문하지 않으면 BFS 탐색.
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!map[i][j].equals("X") && !visited[i][j]){
                    total = 0;
                    BFS(i,j);
                    // 탐색 후 total에 저장.
                    // answer에 저장.
                    answer.add(total);
                }
            }
        }
        if(answer.size() == 0){
            answer.add(-1);
        }else{
            Collections.sort(answer);
        }
        
        return answer;
    }
    
    //숫자 함수
    // private static boolean isNumeric(String num){
    //     for(Character c : num.toCharArray()){
    //         if(!Character.isDigit(c)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    
    //BFS탐색.
    private static void BFS(int s,int d){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{s,d});
        visited[s][d] = true;
        total+=Integer.parseInt(map[s][d]);
        while (!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || ny < 0 || nx>=n || ny >=m) continue;
                //방문 안했거나 X가 아니면 BFS 탐색.
                if(!visited[nx][ny] && !map[nx][ny].equals("X")){
                    visited[nx][ny] = true;
                    total+=Integer.parseInt(map[nx][ny]);
                    q.offer(new int[]{nx,ny});
                }
            }
            
        }
        
    }
}