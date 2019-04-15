package n11559_뿌요뿌요;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static char map[][];
	static boolean check[][];
	static int N = 12;
	static int M = 6;

	static int[] dn = { 0, 0, -1, 1 };
	static int[] dm = { -1, 1, 0, 0 };

	static int answer;
	static boolean flag;

	public static void printMap() {
		for (char[] arr : map) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println();
	}

	public static boolean isRange(int x, int y) {

		if (x < 0 || x >= M || y < 0 || y >= N)
			return false;

		return true;
	}

	public static void remove() {

		while (true) {

			//printMap();
			check = new boolean[N][M];
			flag = false;

			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {

					if (check[n][m] || map[n][m] == '.')
						continue;

					bfs(n, m);

				}
			}

			if (!flag)
				break;
			else {
				answer++;
				move();
			}

		}
	}

	public static void bfs(int n, int m) {

		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(m, n));

		char c = map[n][m];
		int count = 0;

		ArrayList<Point> list = new ArrayList<>();

		while (!queue.isEmpty()) {
			Point temp = queue.poll();
			list.add(temp);
			count++;
			check[temp.y][temp.x] = true;

			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dm[i];
				int ny = temp.y + dn[i];

				if (!isRange(nx, ny) || check[ny][nx] || map[ny][nx] != c)
					continue;

				check[ny][nx] = true;
				queue.add(new Point(nx, ny));
			}
		}

		if (count > 3) {
			flag = true;

			for (int i = 0; i < count; i++) {
				Point temp = list.get(i);
				map[temp.y][temp.x] = '.';
			}
		}
	}

	public static void move() {
		for (int m = 0; m < M; m++) {
			int index = 0;

			for (int n = N - 1; n >= 0; n--) {

				if (map[n][m] == '.')
					index++;
				else {
					char temp = map[n][m];
					map[n][m] = '.';
					map[n + index][m] = temp;
				}

			}
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(Main.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		remove();
		System.out.println(answer);
	}
}
