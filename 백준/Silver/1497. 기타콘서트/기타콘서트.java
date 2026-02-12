import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n,m;
    static int maxS = 0;
    static int min_count = Integer.MAX_VALUE;
    static String[] name, song;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        name = new String[n];
        song = new String[n];
        check = new int[m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            song[i] = st.nextToken();
        }
        backTracking(0,0,0);
        if(min_count == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else{
            System.out.println(min_count);
        }
    }

    private static void backTracking(int idx, int guitarCount, int songCount) {
        if (songCount > 0) {
            if (songCount > maxS) {
                maxS = songCount;
                min_count = guitarCount;
            } else if (songCount == maxS) {
                if (min_count == -1 || guitarCount < min_count) {
                    min_count = guitarCount;
                }
            }
        }
        if(idx == n) return;

        int songs = 0;
        for(int i = 0; i < m; i++){
            if(song[idx].charAt(i) == 'Y'){
                if(check[i] == 0){
                    songs++;
                }
                check[i]++;
            }
        }
        backTracking(idx+1,guitarCount+1,songCount+songs);

        for(int i = 0; i < m; i++){
            if(song[idx].charAt(i) == 'Y'){
                check[i]--;
            }
        }
        backTracking(idx+1,guitarCount,songCount);
    }
}