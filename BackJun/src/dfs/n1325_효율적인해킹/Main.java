package dfs.n1325_효율적인해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static boolean map[][];
	static int N;
	static int memo[];
	static int count;

	public static void main(String[] args) throws IOException {

		System.setIn(Main.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new boolean[N + 1][N + 1];
		memo = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[b][a] = true;
		}

		for (int i = 1; i <= N; i++) {
			boolean visited[] = new boolean[N + 1];
			visited[i] = true;
			dfs(i, visited);

		}

		System.out.println(Arrays.toString(memo));

		int max = memo[1];
		StringBuilder sb = new StringBuilder();
		sb.append("1 ");

		for (int i = 2; i <= N; i++) {
			if (memo[i] == max)
				sb.append(i + " ");
			else if (memo[i] > max) {
				max = memo[i];
				sb = new StringBuilder();
				sb.append(i + " ");
			}
		}

		System.out.println(sb);

	}

	public static int dfs(int idx, boolean visited[]) {

		if (memo[idx] != 0)
			return memo[idx];

		int count = 1;

		for (int i = 1; i <= N; i++) {
			if (map[idx][i] && !visited[i]) {
				visited[i] = true;
				count += dfs(idx, visited);
			}
		}

		memo[idx] = count;

		return memo[idx];

	}

}
