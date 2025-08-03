//불량 사용자 프로도에게 전달
//아이디 중 일부 문자를 * 가림.
// 가리고자 하는 문자 하나에 * 문자 하나 사용/
import java.util.*;
class Solution {
    static boolean[] visited;
    static int n, m;
    static int answer = 0;
    static List<String> name = new ArrayList<>();
    static Set<String> user = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        n = user_id.length;
        m = banned_id.length;
        visited = new boolean[n];
        DFS(0,user_id,banned_id);
        
        return user.size();
    }
    public static void DFS(int index, String[] user_id, String[] banned_id){
        if(index == m){
            List<String> sorted = new ArrayList<>(name);
            Collections.sort(sorted);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<m; i++){
                sb.append(sorted.get(i)).append("");
            }
            user.add(sb.toString());
            return;
        }
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                String names1 = user_id[i];
                String names2 = banned_id[index];
                if(checkName(names1,names2)){
                    visited[i] = true;
                    name.add(names1);
                    DFS(index+1,user_id,banned_id);
                    name.remove(name.size()-1);
                    visited[i] = false;
                    }
                }
            }
        }
    public static boolean checkName(String name1, String name2){
        if(name1.length()!= name2.length()) return false;
        for(int i = 0; i<name1.length(); i++){
            if(name2.charAt(i) =='*') continue;
            if(name2.charAt(i)!=name1.charAt(i)) return false;
        }
        return true;
    }
    
}