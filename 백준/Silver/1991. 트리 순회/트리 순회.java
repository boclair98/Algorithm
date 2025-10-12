import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    static int n;
    static int[] node;
    static boolean[] visited;
    static List<List<char[]>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i<=26; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);
            graph.get(a-'A').add(new char[]{b,c});
        }
        pre('A');
        System.out.println();
        inorder('A');
        System.out.println();
        post('A');
    }

    private static void pre(char Node) {
        if(Node == '.') return;
        System.out.print(Node+"");
        for(char[] child : graph.get(Node-'A')){
            pre(child[0]);
            pre(child[1]);
        }
    }
    private static void inorder(char Node){
        if(Node == '.') return;
        for(char[] child : graph.get(Node -'A')){
            inorder(child[0]);
            System.out.print(Node+"");
            inorder(child[1]);
        }
    }

    private static void post(char Node){
        if(Node == '.') return;
        for(char[] child : graph.get(Node -'A')){
            post(child[0]);
            post(child[1]);
            System.out.print(Node+"");
        }
    }


}
