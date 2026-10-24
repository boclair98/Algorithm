class Solution {
    static int[] parents;
    static int find(int x){
        if(x != parents[x]){
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
    static boolean union(int x , int y){
        int rootx = find(x);
        int rooty = find(y);
        if(rootx == rooty) return false;
        parents[rooty] = rootx;
        return true;
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parents = new int[n+1];
        for(int i = 0; i<= n; i++){
            parents[i] = i;
        }
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers.length; j++){
                if(i == j) continue;
                if(computers[i][j] == 1){
                    union(i,j);
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(parents[i] == i) answer++;
        }
        return answer;
    }
}