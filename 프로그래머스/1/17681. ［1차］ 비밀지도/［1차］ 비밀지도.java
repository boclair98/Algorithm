class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        Character[][] map1 = new Character[n][n];
        Character[][] map2 = new Character[n][n];
        
        for(int i = 0; i<n; i++){
            String binary = Integer.toBinaryString(arr1[i]);

            StringBuilder str = new StringBuilder(binary);
            while (str.length() < n){
                str.insert(0,'0');
            }
            for(int j = 0; j<n; j++){
                map1[i][j] = str.charAt(j);
            }
        }
        
        for(int i = 0; i<n; i++){
            String binary = Integer.toBinaryString(arr2[i]);
            StringBuilder str = new StringBuilder(binary);
            while (str.length() < n){
                str.insert(0,'0');
            }
            for(int j = 0; j<n; j++){
                map2[i][j] = str.charAt(j);
            }
        }
        
        for(int i = 0; i<n; i++){
            String ans ="";
            for(int j = 0; j<n; j++){
                if(map1[i][j] == '1' || map2[i][j] == '1'){
                    ans+="#";
                }else{
                    ans+=" ";
                }
            }
            answer[i] = ans;
        }
        
        return answer;
    }
}
