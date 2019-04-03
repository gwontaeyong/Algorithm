package d4.n4796_의석이의우뚝선산;

import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    static int max;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub

        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = scan.nextInt();
            int mountain[] = new int[n];
            max = 0;

            for (int i = 0; i < n; i++) {
                mountain[i] = scan.nextInt();
            }

            for (int i = 1; i < n - 1; i++) {
                int temp = mountain[i];

                //왼쪽 혹은 오른쪽이 조건에 안맞으면 통과
                if (temp <= mountain[i - 1] || temp <= mountain[i + 1])
                    continue;

                int left = 1;
                int right = 1;

                temp = mountain[i - 1];
                //왼쪽 체크
                for (int j = i - 2; j >= 0; j--) {
                    if (mountain[j] > temp)
                        break;
                    else {
                        temp = mountain[j];
                        left++;
                    }
                }
                temp = mountain[i + 1];
                //오른쪽 체크
                for (int j = i + 2; j < n; j++) {
                    if (mountain[j] > temp)
                        break;
                    else {
                        temp = mountain[j];
                        right++;
                    }
                }

                max += left * right;
            }
            System.out.println(String.format("#%d %d", t, max));
        }
    }
}
