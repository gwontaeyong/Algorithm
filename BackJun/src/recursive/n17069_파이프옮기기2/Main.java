package recursive.n17069_파이프옮기기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean map[][];

    static long dp[][][];

    static int H = 0;
    static int V = 1;
    static int C = 2;

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];

        // 장애물이 있으면 true
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().equals("1");
            }
        }

        dp = new long[N][N][3];
        dp[0][1][H] = 1;

        //가로로 출발하는 경우
        for(int i = 2; i < N; i++){
            if(map[0][i])
                continue;
            dp[0][i] = dp[0][i - 1];
        }


        for (int i = 1; i < N; i++) {
            for (int j = 2; j < N; j++) {

                if(map[i][j])
                    continue;

                dp[i][j][H] = dp[i][j-1][H] + dp[i][j -1][C];
                dp[i][j][V] = dp[i-1][j][V] + dp[i-1][j][C];

                if( map[i-1][j] || map[i][j-1])
                    continue;

                dp[i][j][C] = dp[i - 1][j-1][H] + dp[i - 1][j-1][V]+ dp[i - 1][j-1][C];
            }
        }

        long answer = dp[N-1][N-1][C] + dp[N-1][N-1][V] + dp[N-1][N-1][H];
        System.out.println(answer);
    }


}
