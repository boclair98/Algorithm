import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i<t*m; i++){
            sb1.append(Integer.toString(i,n));
        }
        for(int i =p-1 ; i<t*m; i+=m){
            sb2.append(sb1.charAt(i));
        }
        return sb2.toString().toUpperCase();
    }
}