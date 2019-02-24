package bfs.n2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	private static int answer;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(Main.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		boolean check[][] = new boolean[N + 1][M + 1];
		char map[][] = new char[N + 1][M + 1];
		answer = 0;

		for (int i = 1; i <= N; i++) {
			char arr[] = br.readLine().toCharArray();

			for (int j = 0; j < M; j++) {

				map[i][j + 1] = arr[j];
			}
		}
		bfs(map, new boolean[N + 1][M + 1]);

		System.out.println(answer);
	}

	public static void bfs(char[][] map, boolean check[][]) {

		Queue<Data> queue = new LinkedList<>();

		check[0][0] = true;

		queue.add(new Data(1, 1, 1));

		while (!queue.isEmpty()) {

			Data d = queue.poll();

			if (d.x == N && d.y == M) {
				answer = d.cost;
				return;
			}

			for (int i = 0; i < 4; i++) {

				int nx = d.x + dx[i];
				int ny = d.y + dy[i];

				if (nx < 0 || nx > N || ny < 0 || ny > M)
					continue;

				if (!check[nx][ny] && map[nx][ny] == '1') {
					queue.add(new Data(nx, ny, d.cost + 1));
					check[nx][ny] = true;
				}

			}
		}

	}

	static class Data {
		int x;
		int y;
		int cost;

		Data(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}

}
