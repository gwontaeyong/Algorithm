package d5.n3308_최장증가부분수열_hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.setIn(Solution.class.getResourceAsStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int dp[] = new int[n];

            for (int i = 0; i < n; i++) {

                dp[i] = 1;

                for (int j = 0; j < i; j++) {
                    if (arr[j] < arr[i] && 1 + dp[j] > dp[i])
                        dp[i] = 1 + dp[j];
                }

            }


        }
    }
}
