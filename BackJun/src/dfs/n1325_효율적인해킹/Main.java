package dfs.n1325_효율적인해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] list;
    static int N;
    static int M;
    static int dp[];
    static int max;
    static boolean visited[];


    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        dp = new int[N + 1];

        max = 0;

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);
        }


        StringBuilder sb = new StringBuilder();
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {

            visited[i] = true;
            int res = solve(i);

            if (max < res) {
                sb = new StringBuilder();
                sb.append(i + " ");
                max = res;
            } else if (max == res)
                sb.append(i + " ");
            visited[i] = false;

        }

        System.out.println(sb);

    }

    static int solve(int cur) {
        if (dp[cur] != 0)
            return dp[cur];

        dp[cur] = 1;

        for (int next : list[cur]) {

            if (visited[next])
                continue;

            visited[next] = true;
            dp[cur] += solve(next);
            visited[next] = false;
        }

        return dp[cur];
    }

}
