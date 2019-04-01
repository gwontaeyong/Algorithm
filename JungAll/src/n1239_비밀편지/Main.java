package n1239_비밀편지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {


    static String message[] = {"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};
    static char cm[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    static int bm[] = {0, 15, 19, 28, 38, 41, 53, 58};

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("INPUT.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Character> secret = new HashMap<>();

        for (int i = 0; i < 8; i++) {
            secret.put(bm[i], cm[i]);
        }

        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();

        String answer = "";

        for (int i = 0; i < N; i++) {

            String m = line.substring(6 * i, 6 * i + 6);

            boolean flag = false;

            for (int j = 0; j < 8; j++) {  // 8개의 숫자중 맞는 것을 확인한다.

                int count = 0;

                for (int k = 0; k < 6; k++) {

                    if (message[j].charAt(k) != m.charAt(k))
                        count++;

                }

                if (count <= 1) {
                    m = message[j];
                    flag = true;
                    break;
                }

            }

            if (flag)
                answer += secret.get(Integer.parseInt(m, 2));
            else {
                answer = String.valueOf(i + 1);
                break;
            }


        }

        System.out.println(answer);

        int n = 8;

        for (int j = 0; j < 3; j++) {

            if ((n & (1 << j)) != 0) {
                System.out.println(j);
            }

        }


    }
}
