package d4.n3234_준환이의양팔저울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int chu[];
    static long answer;
    static long sum;

    static boolean visited[];
    static int exponential[] = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
    static int factorial[] = {0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public static void main(String[] args) throws IOException {
        System.setIn(Solution.class.getResourceAsStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            N = Integer.parseInt(br.readLine());
            chu = new int[N];
            answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                chu[i] = Integer.parseInt(st.nextToken());
                sum += chu[i];
            }
            visited = new boolean[N];
            dfs(0, 0, 0);

            System.out.println(String.format("#%d %d", t, answer));
        }
    }

    public static void dfs(int left, int right, int index) {

        //System.out.println("left" + left + " : right " + right);
//
//
//        if (right >= sum / 2) {
//            return;
//        }

        if (index == N) {
            //System.out.println(left);
            answer++;
            return;
        }

        if (left > sum / 2) {

            answer += exponential[N - index] * factorial[N - index];
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(left + chu[i], right, index + 1);
                if (right + chu[i] <= left)
                    dfs(left, right + chu[i], index + 1);
                visited[i] = false;
            }
        }
    }

}
