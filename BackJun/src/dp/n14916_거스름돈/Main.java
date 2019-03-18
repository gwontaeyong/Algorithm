package dp.n14916_거스름돈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int change[] = {0, 2, 5};

    public static void main(String[] args) throws IOException {
        //System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        int dp[] = new int[M + 1];

        for (int i = 1; i < change.length; i++) {
            if(change[i]<=M)
                dp[change[i]]=1;
        }
        for (int i = 1; i < change.length; i++) {

            for (int m = change[i]+1; m <= M; m++) {

                if (dp[m - change[i]] == 0) {
                    continue;
                }

                if (dp[m] != 0) {
                    dp[m] = Math.min(dp[m], dp[m - change[i]] + 1);
                } else
                    dp[m] = dp[m - change[i]] + 1;

            }
        }
        System.out.println(Arrays.toString(dp));
//        StringBuilder sb  = new StringBuilder();
//        sb.append("[");
//        for (int i = 0; i <= M ; i++) {
//            sb.append(i + ", ");
//        }
//        sb.append("]");
//        System.out.println(sb);
//        for(int arr:dp)
//            System.out.print(arr+" ");

        System.out.println((dp[M] == 0)?-1:dp[M]);


    }
}
