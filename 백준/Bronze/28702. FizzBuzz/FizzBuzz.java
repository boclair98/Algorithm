import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = br.readLine();
        }

        int nextNum = 0;
        // 숫자가 나온 위치에 따라 보정
        for (int i = 0; i < 3; i++) {
            if (isNumeric(arr[i])) {
                nextNum = Integer.parseInt(arr[i]) + (3 - i);
                break;
            }
        }
        System.out.println(getFizzBuzz(nextNum));
    }

    // 숫자 판별 함수
    private static boolean isNumeric(String s) {
        return s.matches("\\d+");
    }

    // FizzBuzz 결과 반환 함수
    private static String getFizzBuzz(int n) {
        if (n % 15 == 0)        return "FizzBuzz";
        else if (n % 3 == 0)    return "Fizz";
        else if (n % 5 == 0)    return "Buzz";
        else                    return Integer.toString(n);
    }
}
