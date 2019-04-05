package 모의역량테스트.n1953_탈주범검거;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static boolean pip[][] = { { false, false, false, false }, { true, true, true, true },
			{ false, false, true, true }, { true, true, false, false }, { false, true, true, false },
			{ false, true, false, true }, { true, false, false, true }, { true, false, true, false } };

	public static int L = 0;
	public static int R = 1;
	public static int U = 2;
	public static int D = 3;

	public static int[] dm = { -1, 1, 0, 0 };
	public static int[] dn = { 0, 0, -1, 1 };

	public static int N;
	public static int M;

	static int map[][];
	static boolean visited[][];

	static int answer;

	public static boolean isConnect(int p1, int d1, int p2, int d2) {

		if (pip[p1][d1] && pip[p2][d2])
			return true;
		else
			return false;
	}

	public static class Node {
		int n;
		int m;
		int d;
		int p;

		Node(int m, int n, int d, int p) {
			this.n = n;
			this.m = m;
			this.d = d;
			this.p = p;
		}

		@Override
		public String toString() {
			return "n=" + n + ", m=" + m + ", d=" + d;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(Solution.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			answer = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			int dn = Integer.parseInt(st.nextToken());
			int dm = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
				}
			}

			answer = bfs(dm, dn, k);

			System.out.println(String.format("#%d %d", t, answer));

		}

	}

	public static int bfs(int x, int y, int k) {

		Queue<Node> queue = new LinkedList<>();
		visited[y][x] = true;

		int count = 1;
		int answer = 1;

		// 처음 위치에서 이동 가능한 방향으로 출발을 한다.
		for (int i = 0; i < 4; i++) {
			if (pip[map[y][x]][i]) {
				queue.add(new Node(x, y, i, map[y][x]));
			}
		}

		while (!queue.isEmpty()) {

			int size = queue.size();

			if (count == k)
				break;

			for (int i = 0; i < size; i++) {

				Node p = queue.poll();

				int nx = p.m + dm[p.d];
				int ny = p.n + dn[p.d];
				int input = findInput(p.d);
				
				// 범위 밖으로 나가던지 방문 했던 곳이면
				if (!isRange(nx, ny) || visited[ny][nx] || !isConnect(p.p, p.d, map[ny][nx], input))
					continue;

				visited[ny][nx] = true;
				
				answer++;
				
				for (int j = 0; j < 4; j++) {
					if(j == input)
						continue;
					if (pip[map[ny][nx]][j]) {
						queue.add(new Node(nx, ny, j, map[ny][nx]));
					}

				}
			}
			
			count++;
		}

		return answer;

	}

	public static boolean isRange(int x, int y) {
		if (x < 0 || x >= M || y < 0 || y >= N)
			return false;
		return true;
	}

	public static int findInput(int d) {
		int input = 0;

		if (d == L)
			input = R;
		else if (d == R)
			input = L;
		else if (d == U)
			input = D;
		else if(d == D)
			input = U;

		return input;
	}

}
