package dfs.n1987_알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char map[][];
    static boolean visited[];

    static int dc[] = {-1, 1, 0, 0};
    static int dr[] = {0, 0, -1, 1};

    static int R;
    static int C;

    static int count;
    static int max;

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


        map = new char[R][C];
        visited = new boolean[26];

        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }

        visited[map[0][0] - 'A'] = true;

        dfs(0, 0);

        System.out.println(max);
        //System.out.println('Z' - 'A');
        // System.out.println(Arrays.toString(visited));
    }

    public static void dfs(int r, int c) {

        count++;

        max = (count > max) ? count : max;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C)
                continue;

            if (visited[map[nr][nc] - 'A'])
                continue;

            visited[map[nr][nc] - 'A'] = true;
            dfs(nr, nc);
            count--;
            visited[map[nr][nc] - 'A'] = false;
        }

    }


}
