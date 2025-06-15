
class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        int lx = 0;
        int ly = 0;
        int rx = 0;
        int ry = 0;
        Character[][] map = new Character[n][m];
        for(int i = 0; i<n; i++){
            String word = wallpaper[i];
            for(int j = 0; j<m; j++){
                map[i][j] = word.charAt(j);
            }
        }
        for(int i = 0; i<n; i++){
            boolean check = false;
            for(int j = 0; j<m; j++){
                if(map[i][j] =='#'){
                    lx = i;
                    check = true;
                    break;
                }
            }
            if(check){
                break;
            }
        }
        for(int i = 0; i<m; i++){
            boolean check = false;
            for(int j = 0; j<n; j++){
                if(map[j][i] =='#'){
                    ly = i;
                    check = true;
                    break;
                }
            }
            if(check){
                break;
            }
        }
        for(int i = n-1; i>=0; i--){
            boolean check = false;
            for(int j = m-1; j>=0; j--){
                if(map[i][j] =='#'){
                    rx = i;
                    check = true;
                    break;
                }
            }
            if(check){
                break;
            }
        }
        
        for(int i = m-1; i>=0; i--){
            boolean check = false;
            for(int j = n-1; j>=0; j--){
                if(map[j][i] =='#'){
                    ry = i;
                    check = true;
                    break;
                }
            }
            if(check){
                break;
            }
        }
        
        // System.out.println(lx+" "+ly);
        // System.out.println(rx+" "+ry);
        answer[0] = lx;
        answer[1] = ly;
        answer[2] = rx + 1;
        answer[3] = ry + 1;
        return answer;
    }
}