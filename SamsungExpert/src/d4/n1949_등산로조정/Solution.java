package d4.n1949_등산로조정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int map[][];
    static boolean visit[][];

    static int n;
    static int K;
    static int answer;
    static int ans;

    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static class Rode {
        int x;
        int y;
        int count;
        boolean isCut;

        Rode(int x, int y, int count, boolean isCut) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.isCut = isCut;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            answer = 0;
            ans = 0;
            int max = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == max) {
                        boolean visited[][] = new boolean[n][n];
                        //visit = new boolean[n][n];
                        //dfs(i, j, 1, false);
                        dfs(visited, j, i, 1, false);
                    }
                }
            }

            System.out.println(String.format("#%d %d", tc, answer));

        }
    }

    private static void dfs(int y, int x, int len, boolean cut) {
        //cut이 true 면 공사를 했다.

        visit[y][x] = true;
//      if (map[y][x] == bottom) {
        answer = answer < len ? len : answer;
//          return;
//      }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (!isRange(nx, ny)|| visit[ny][nx])
                continue;
            if (map[ny][nx] < map[y][x]) {
                dfs(ny, nx, len + 1, cut);
            } else { //같거나 높으면
                if (!cut) { //cut이 false면 아직 공사를 안한 상태
                    for (int k = 1; k <= K; k++) {
                        int tmp = map[ny][nx];
                        map[ny][nx] -= k;
                        if (map[ny][nx] < map[y][x])
                            dfs(ny, nx, len + 1, true);
                        map[ny][nx] = tmp;
                    }
                }
            }
            visit[ny][nx] = false;
        }

    }

    public static void dfs(boolean visited[][], int x, int y, int count, boolean isCut) {

        visited[y][x] = true;
        answer = Math.max(answer, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];


            if (!isRange(nx, ny) || visited[ny][nx])
                continue;

            if (map[ny][nx] < map[y][x]) {// 다음에 갈 등산로가 현재보다 작을 경우
                dfs(visited, nx, ny, count + 1, isCut);
            } else {
                if (!isCut) {
                    for (int k = 1; k <= K; k++) {
                        int tmp = map[ny][nx];
                        map[ny][nx] -= k;
                        if (map[ny][nx] < map[y][x])
                            dfs(visited, nx, ny, count + 1, true);
                        map[ny][nx] = tmp;
                    }
                }
            }
            visited[ny][nx] = false;
        }
    }

    public static boolean isRange(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n)
            return false;
        return true;
    }

}