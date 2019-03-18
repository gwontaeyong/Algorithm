package d4.n3143_가장빠른문자열타이핑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.setIn(Solution.class.getResourceAsStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            String line[] = br.readLine().split(" ");

            String A = line[0];
            String B = line[1];
            char fb = B.charAt(0);

            int alen = A.length();
            int blen = B.length();

            int typing = 0;

            for (int i = 0; i < alen; ) {

                if (i + blen - 1 < alen) {// B길이 만큼 탐색 할 수 있으면

                    boolean flag = true; // B의 중복이 이러나는지


                    for (int j = i; j < i + blen; j++) {
                        if (A.charAt(j) != B.charAt(j - i)) { // 다르면 무조건 false;
                            flag = false;
                            break;
                        }
                    }

                    typing++;

                    if (flag) { //문자열이 B와 같다면
                        //typing을 1 증가하고
                        //typing++;
                        i += blen;
                    } else {
                        //typing을 blen만큼 증가
                        //typing += blen;
                        i++;
                    }

                } else {
                    typing += alen - i;
                    break;
                }
            }

            System.out.println(String.format("#%d %d", t, typing));


        }
    }

}
