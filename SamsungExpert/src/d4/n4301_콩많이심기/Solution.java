package d4.n4301_콩많이심기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int M;

    static int dx[] = {2, -2, 0, 0};
    static int dy[] = {0, 0, -2, 2};

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub

        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            boolean map[][] = new boolean[M][N];

            int answer = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!map[i][j]) {
                        answer++;
                        for (int k = 0; k < 4; k++) {
                            int nx = j + dx[k];
                            int ny = i + dy[k];


                            if (isRange(nx, ny)) {
                                map[ny][nx] = true;
                            }
                        }
                    }

                }
            }


            System.out.println(String.format("#%d %d", t, answer));
        }


    }

    public static boolean isRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M)
            return false;

        return true;
    }

}
