package d4.n1249_보급로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int map[][];
    static int N;

    static int min;

    static int dn[] = {-1, 1, 0, 0};
    static int dm[] = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N + 1][N + 1];
            min = 987456321;

            for (int i = 1; i <= N; i++) {
                char arr[] = br.readLine().toCharArray();
                for (int j = 1; j <= N; j++)
                    map[i][j] = arr[j-1] - '0';
            }

            dfs(1, 1, 0, new boolean[N+1][N+1]);
            System.out.println(String.format("#%d %d", tc, min));
        }
    }

    public static void dfs(int n, int m, int sum, boolean visited[][]) {


        if(sum > min)
            return;

        if(n == N && m == N){
            min = sum;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nN = n + dn[i];
            int nM = m + dm[i];

            if(!isRange(nN, nM) || visited[nN][nM])
                continue;

            visited[nN][nM] = true;
            dfs(nN, nM, sum + map[nN][nM], visited);
            visited[nN][nM] = false;
        }

    }

    public static boolean isRange(int n, int m){
        if(n < 1 || n > N || m < 1 || m > N)
            return false;

        return true;
    }
}
