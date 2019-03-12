package recursive.n17069_파이프옮기기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean map[][];

    static int S = 0;
    static int L = 1;
    static int R = 2;

    static int C = 0; //크로스
    static int H = 1; //가로
    static int V = 2; //세로

    // state, direction
    static int mx[][] = {{1, 1, 0}, {1, 1, 1}, {0, 1, -1}};
    static int my[][] = {{1, 0, 1}, {0, -1, 1}, {1, 1, 1}};
    static int dp[][][];

    static int count;

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //변수 초기화
        count = 0;
        N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];

        // 장애물이 있으면 true
        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().equals("1");
            }
        }

        //
        dp = new int[3][N][N];

        for (int i = 0; i < N; i++) {
            if (!map[0][i])
                dp[H][0][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {

                if(map[i][j])
                    continue;



                dp[H][i][j] = dp[C][i][j - 1] + dp[H][i][j - 1];
                dp[V][i][j] = dp[C][i - 1][j] + dp[V][i - 1][j];
                dp[V][i][j] = dp[C][i - 1][j - 1] + dp[V][i - 1][j - 1] + dp[H][i - 1][j - 1];

            }
        }


        System.out.println(count);

    }

    static void printS(int x, int y, int s, int d) {

        char ss = (s == 0) ? 'C' : (s == 1) ? 'H' : 'V';
        char dd = (d == 0) ? 'S' : (d == 1) ? 'L' : 'R';

        System.out.println(String.format("X = %d, Y = %d, %c %c", x, y, ss, dd));
    }

}
