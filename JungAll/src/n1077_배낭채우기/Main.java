package n1077_배낭채우기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int W = scan.nextInt();

        //weight  and worth
        int jewelry[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            jewelry[i][0] = scan.nextInt();
            jewelry[i][1] = scan.nextInt();
        }


        int dp[] = new int[W + 1];


        for (int i = 0; i <= W; i++) {

            int weight = jewelry[0][0];
            int worth = jewelry[0][1];

            if (weight > i)
                continue;

            dp[i] = (i / weight) * worth;

        }
        for (int i = 1; i < N; i++) {
            int weight = jewelry[i][0];
            int worth = jewelry[i][1];

            int temp[] = dp;

            for (int j = 0; j <= W; j++) {

                if (weight > j)
                    continue;

                int nW = temp[j - weight] + worth;

                if (nW > dp[j])
                    temp[j] = nW;
            }
        }

        System.out.println(dp[W]);
    }

}
