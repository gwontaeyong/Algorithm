package d4.n7088_은기의송아지세기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub

        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            int dp[][] = new int[N + 1][4];

            for (int i = 1; i <= N; i++) {
                int cow = Integer.parseInt(br.readLine());

                for (int j = 1; j <= 3; j++) {
                    dp[i][j] = dp[i - 1][j];
                }
                dp[i][cow] = dp[i][cow] + 1;


            }


            bw.write(String.format("#%d\n", tc));

            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                int first = dp[B][1] - dp[A - 1][1];
                int second = dp[B][2] - dp[A - 1][2];
                int third = dp[B][3] - dp[A - 1][3];
                ;


                bw.write(String.format("%d %d %d\n", first, second, third));

            }


            bw.flush();
        }
    }
}
