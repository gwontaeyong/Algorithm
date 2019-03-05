package dp.n11048.이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());


        int[][] map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        //오른쪽으로 한칸 이동
        for (int i = 1; i < C; i++) {
            map[0][i] = map[0][i] + map[0][i - 1];
        }


        for (int i = 1; i < R; i++) {
            map[i][0] = map[i][0] + map[i - 1][0];

            for (int j = 1; j < C; j++) {

                int max = Math.max(map[i - 1][j - 1], Math.max(map[i - 1][j], map[i][j - 1]));

                map[i][j] += max;
            }

        }

        System.out.println(map[R-1][C-1]);


    }
}
