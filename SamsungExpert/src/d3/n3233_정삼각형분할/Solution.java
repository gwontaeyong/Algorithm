package d3.n3233_정삼각형분할;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/data/input_6853.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String line[] = br.readLine().split(" ");

            long A = Long.parseLong(line[0]);
            long B = Long.parseLong(line[1]);

            A = A / B;


            System.out.format("#%d %d\n", test_case, A * A);

        }
    }
}
