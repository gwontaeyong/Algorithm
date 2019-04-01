package d4.n1952_수영장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int pay[];
    static int months[];
    static int dp[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            pay = new int[4];
            months = new int[13];
            dp = new int[13];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 4; i++)
                pay[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= 12; i++)
                months[i] = Integer.parseInt(st.nextToken());


            for (int i = 1; i < 13; i++) {

                if (months[i - 1] == 0) {
                    dp[i] = dp[i - 1];
                    continue;
                }

                dp[i] = Math.min(dp[i - 1] + pay[0] * months[i - 1], dp[i - 1] + pay[1]);

                if (i >= 3) {
                    dp[i] = Math.min(dp[i], dp[i - 3] + pay[2]);
                }
            }


            int answer = Math.min(dp[12], pay[3]);

            System.out.println(answer);


        }
    }
}