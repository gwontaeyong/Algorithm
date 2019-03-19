package d4.n1865_동철이의일분배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static double map[][];
    static double max;
    static double maxN;

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int n = Integer.parseInt(br.readLine());

            map = new double[n][n];
            max = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    double k = Double.parseDouble(st.nextToken());
                    map[i][j] = k / 100.0;
                }
            }


//            if (tc == 36) {
            //System.out.println(n);

//                for (double[] arr : map)
//                    System.out.println(Arrays.toString(arr));

            permutation(new boolean[n], 0, n, 100);
            System.out.println(String.format("#%d %.6f", tc, max));
//            }


        }
    }

    public static void permutation(boolean visisted[], int count, int n, double percent) {


        if (percent < max)
            return;

        if (count == n) {
            max = percent;
            return;
        }


        for (int i = 0; i < n; i++) {

            if (visisted[i] || map[count][i] == 0)
                continue;

            double newP = percent * map[count][i];

            visisted[i] = true;
            permutation(visisted, count + 1, n, newP);
            visisted[i] = false;
        }
    }
}