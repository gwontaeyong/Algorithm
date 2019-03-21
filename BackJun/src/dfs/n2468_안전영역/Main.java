package dfs.n2468_안전영역;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int map[][];
    static boolean visited[][];

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static int N;
    static int min;
    static int max;

    static int answer;
    static int count;

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        min = 100;
        max = 1;
        answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());

                min = (min < n) ? min : n;
                max = (max > n) ? max : n;

                map[i][j] = n;
            }
        }

        for (int i = min; i <= max; i++) {
            count = 0;
            visited = new boolean[N][N];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {

                    if (map[r][c] > i && !visited[r][c]) {
                        dfs(r, c, i);
                        count++;
                    }

                }
            }

            answer = Math.max(count, answer);
        }

        System.out.println(answer);

    }

    public static void dfs(int r, int c, int depth) {


        if (!isRange(r, c) || visited[r][c])
            return;

        if (map[r][c] <= depth)
            return;


        visited[r][c] = true;


        for (int i = 0; i < 4; i++) {
            int nr = r + dy[i];
            int nc = c + dx[i];

            dfs(nr, nc, depth);
        }


    }

    public static boolean isRange(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N)
            return false;

        return true;
    }


}
