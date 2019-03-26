package d4.n2105_디저트카페;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int map[][];
    static int n;
    static int answer;

    static int dx[][] = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    static int dy[][] = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            answer = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n - 2; j++) {
                    boolean visited[][] = new boolean[n][n];
                    visited[i][j] = true;
                    boolean dessert[] = new boolean[101];
                    dessert[map[i][j]] = true;

                    dfs(visited, dessert, j, i, 0, 1);
                }
            }

            System.out.println(answer);


        }
    }

    public static void dfs(boolean visited[][], boolean dessert[], int x, int y, int curve, int count) {



    }


    public static boolean isRange(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n)
            return false;

        return true;
    }
}