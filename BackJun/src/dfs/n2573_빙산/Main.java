package dfs.n2573_빙산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	static int map[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static Queue<Bingha> queue;

	public static class Bingha {
		int x;
		int y;
		int h;

		Bingha(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}

		public String toString() {
			return h + " ";
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// System.setIn(Main.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		queue = new LinkedList<>();

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if (map[n][m] != 0)
					queue.add(new Bingha(m, n, map[n][m]));
			}
		}

		int answer = 0;
		int count = 0;
		
		while (!queue.isEmpty()) {
			count++;
			melt();
			int b = countB();

			if (b >= 2) {
				answer = count;
				break;
			}

		}

		System.out.println(answer);
	}

	public static void printMap() {
		for (int arr[] : map)
			System.out.println(Arrays.toString(arr));
	}

	public static int countB() {

		int size = queue.size();
		boolean visited[][] = new boolean[N][M];

		int count = 0;

		for (int i = 0; i < size; i++) {
			Bingha temp1 = queue.poll();
			Queue<Bingha> bfs = new LinkedList<>();

			if (!visited[temp1.y][temp1.x]) {
				bfs.add(temp1);
				visited[temp1.y][temp1.x] = true;

				while (!bfs.isEmpty()) {

					Bingha temp = bfs.poll();
					for (int j = 0; j < 4; j++) {
						int nx = temp.x + dx[j];
						int ny = temp.y + dy[j];

						if (!isRange(nx, ny) || map[ny][nx] == 0 || visited[ny][nx])
							continue;

						visited[ny][nx] = true;
						bfs.add(new Bingha(nx, ny, 0));
					}
				}

				count++;
			}
			queue.add(temp1);
		}

		return count;
	}

	public static void melt() {

		ArrayList<Bingha> remove = new ArrayList<>();
		int size = queue.size();
		// 사라질 빙산 확인하기
		for (int j = 0; j < size; j++) {
			Bingha temp = queue.poll();

			int see = 0;

			// 주변 바다 갯수 세기
			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];

				if (!isRange(nx, ny) || map[ny][nx] != 0)
					continue;

				see++;
			}

			int nh = temp.h - see;

			if (nh > 0) {
				map[temp.y][temp.x] = nh;
				queue.add(new Bingha(temp.x, temp.y, nh));
			} else
				remove.add(new Bingha(temp.x, temp.y, 0));
		}

		for (Bingha b : remove) {
			map[b.y][b.x] = 0;
		}

	}

	public static boolean isRange(int x, int y) {
		if (x < 0 || x >= M || y < 0 || y >= N)
			return false;
		return true;
	}

}
