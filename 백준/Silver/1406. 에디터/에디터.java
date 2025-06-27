import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> list = new LinkedList<>();
        String word =br.readLine();
        for(int i = 0; i<word.length(); i++){
            list.add(word.charAt(i));
        }
        ListIterator<Character> listIterator = list.listIterator(list.size());

        int count = Integer.parseInt(br.readLine());
        for(int i = 0; i<count; i++){
            String[] words = br.readLine().split(" ");

            char a = words[0].charAt(0);
            if(a == 'L'){
                if(listIterator.hasPrevious()){
                    listIterator.previous();
                }
            }else if(a == 'D'){
                if(listIterator.hasNext()){
                    listIterator.next();
                }
            }else if(a == 'B'){
                if(listIterator.hasPrevious()){
                    listIterator.previous();
                    listIterator.remove();
                }
            }else if ( a == 'P'){
                char b = words[1].charAt(0);
                listIterator.add(b);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        System.out.println(sb);


    }
}