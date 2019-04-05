package d4.n2105_디저트카페;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    static int T, N, sx, sy;
    static int arrX[] = { 1, 1, -1, -1 }; // 아오 아왼 왼위 오위
    static int arrY[] = { 1, -1, -1, 1 };
    static int res;
    static boolean chk[];
    static int[][] map;

    static boolean Range(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N)
            return false;
        return true;
    }

    static void dfs(int x, int y, int status, int cnt) {
        if (x == sx && y == sy && status != -1) {
            res = Math.max(res, cnt);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (status + 1 == i || status == i) { // 다음 이거나 가던길 쭉감
                int nx = x + arrX[i];
                int ny = y + arrY[i];

                if (Range(nx, ny)) {
                    if (chk[map[nx][ny]] == false) {
                        chk[map[nx][ny]] = true;
                        dfs(nx, ny, i, cnt + 1);
                        chk[map[nx][ny]] = false;
                    } else if (chk[map[nx][ny]] == true && nx == sx && ny == sy) {
                        dfs(nx, ny, i, cnt);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            res = 0;
            sx = sy = -1;
            map = new int[N][N];
            chk = new boolean[102];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    chk[map[i][j]] = true;
                    sx = i;
                    sy = j;
                    dfs(i, j, -1, 1);
                    chk[map[i][j]] = false;
                }
            }

            if (res == 0)
                res = -1;
            System.out.println("#" +tc + " " + res);
        }
    }
}