package d4.n4530_극한의청소작업;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub

        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        long fourNum[][] = new long[12 + 1][10];



        long digit = 1;
        for (int i = 1; i < 13; i++)
        {
            fourNum[i][1] = fourNum[i - 1][9] + fourNum[i - 1][1];

            for(int j = 2; j < 10; j++)
            {
                if(j == 5)
                {
                    fourNum[i][j] += fourNum[i][j - 1] + digit;
                    continue;
                }
                fourNum[i][j] = fourNum[i][j - 1] + fourNum[i][1];
            }

            digit *= 10;
        }

        for(long[] floorF: fourNum)
            System.out.println(Arrays.toString(floorF));
        
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            A = (A < 0) ? -1 * A : A;
            B = (B < 0) ? -1 * B : B;
        }
    }
}
