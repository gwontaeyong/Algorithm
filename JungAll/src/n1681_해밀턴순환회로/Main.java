package n1681_해밀턴순환회로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int map[][];
    static int[][] memo;

    static int min;

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        memo = new int[1 << N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        //min = 99999;
        // boolean visited[] = new boolean[N];
        // visited[0] = true;
        // dfs(visited, 0, 1, 0);
        System.out.println(dfs(0, 0, 0));

        //System.out.println(min);

    }

    //boolean 배열 대신 int자료를 통해서 방문 체크. (메모이제이션 시 키값으로 활용할 때 더 유리)
    public static int dfs(int state, int idx, int current) {

        if (idx == N - 1) {
            if (map[current][0] == 0)
                return 987654321;
            else
                return map[current][0];
        }

        int opt = 987654;

        if (memo[state][current] != 0)
            return memo[state][current];

        for (int i = 1; i < N; i++) {
            int mask = 1 << i;

            if ((mask & state) == 0 && map[current][i] != 0) {
                int tmp = dfs(state | mask, idx + 1, i) + map[current][i];
                opt = Math.min(opt, tmp);
            }
        }

        memo[state][current] = opt;

        return opt;
    }

    public static void dfs(boolean visited[], int index, int count, int sum) {

        if (count == N) {

            if (map[index][0] != 0)
                min = Math.min(sum + map[index][0], min);
            return;
        }

        if (sum >= min) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (index == i || map[index][i] == 0)
                continue;

            if (visited[i])
                continue;

            visited[i] = true;
            dfs(visited, i, count + 1, sum + map[index][i]);
            visited[i] = false;

        }

    }

    public static void printMap() {
        for (int[] arr : map)
            System.out.println(Arrays.toString(arr));

        System.out.println();
    }

}
