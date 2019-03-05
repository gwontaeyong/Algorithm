package d3.n3282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int products[][];

    public static void main(String[] args) throws IOException {
        System.setIn(Solution.class.getResourceAsStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            //0 = size
            //1 = value
            products = new int[N + 1][2];

            for (int i = 1; i < N + 1; i++) {
                st = new StringTokenizer(br.readLine());

                products[i][0] = Integer.parseInt(st.nextToken());
                products[i][1] = Integer.parseInt(st.nextToken());
            }

            int result = dinamicPrograming(N, K);

            System.out.printf("#%d %d\n", tc, result);
        }
    }

    public static int dinamicPrograming(int N, int K) {

        int dp[][] = new int[N + 1][K + 1];

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < K + 1; j++) {

                if (i == 0)
                    dp[i][j] = 0;
                else if (products[i][0] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - products[i][0]] + products[i][1]);

            }
        }

        return dp[N][K];
    }
}