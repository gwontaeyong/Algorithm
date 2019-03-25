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


            //1일
            for(int i = 1; i <= 12; i++){
                dp[i] = months[i] * pay[0] + dp[i - 1];
            }
            System.out.println(Arrays.toString(dp));

            //1달
            for(int i = 1; i <= 12; i++){
                int temp = Math.min(dp[i - 1] + pay[1], dp[i - 1] + months[i] * pay[0]);
                dp[i] = Math.min(temp, dp[i]);
            }
            System.out.println(Arrays.toString(dp));

            //3달
            for(int i = 1; i <= 10; i++){

                int temp = dp[i] + dp[i + 1] + dp[i + 2];
                int temp2 = dp[i] + dp[i + 1] + dp[i - 1];
                if(pay[2] < ){
                    for(int j = i; j < i + 3; j++){
                        dp[j] = pay[2] + dp[i - 1];
                    }
                }

            }

            System.out.println(Arrays.toString(dp));


        }
    }
}