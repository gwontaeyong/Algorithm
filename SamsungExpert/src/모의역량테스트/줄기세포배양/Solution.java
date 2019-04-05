package 모의역량테스트.줄기세포배양;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int M;
	static int K;
	static int map[][];

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static int answer;
	static Queue<Node> nq;
	static PriorityQueue<Node> aq;

	public static class Node implements Comparable<Node> {

		int x;
		int y;
		int count;
		int init;

		Node(int x, int y, int init) {
			this.x = x;
			this.y = y;
			this.init = init;
			count = init * 2;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + ", count=" + count + " init=" + init + "]";
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return o.init - this.init;
		}

	}

	public static void main(String[] args) throws IOException {
		System.setIn(Solution.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			answer = 0;

			nq = new LinkedList<>();
			aq = new PriorityQueue<Node>();

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N + K + 2][M + K + 2];

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());

				for (int m = 0; m < M; m++) {
					int init = Integer.parseInt(st.nextToken());

					if (init == 0)
						continue;

					int y = K / 2 + 1 + n;
					int x = K / 2 + 1 + m;

					map[y][x] = init;

					nq.add(new Node(x, y, init));

				}
			}

			bfs();

			System.out.println(String.format("#%d %d", tc, answer));

		}
	}

	static void bfs() {

		int count = 0;

		while (!nq.isEmpty()) {

			// System.out.println(nq);
			if (count == K)
				break;

			int size = nq.size();

			for (int i = 0; i < size; i++) {
				Node temp = nq.poll();

				if (temp.count == temp.init) {
				
					map[temp.y][temp.x] = -1;

					for (int j = 0; j < 4; j++) {
						int nx = temp.x + dx[j];
						int ny = temp.y + dy[j];

						if (map[ny][nx] != 0)
							continue;

						aq.add(new Node(nx, ny, temp.init));
					}

				}

				temp.count--;

				if (temp.count == 0)
					continue;

				nq.add(temp);
			}

			while (!aq.isEmpty()) {
				Node temp = aq.poll();

				if (map[temp.y][temp.x] != 0)
					continue;

				map[temp.y][temp.x] = temp.init;
				nq.add(temp);
			}
			count++;

			//printMap();
		}

		answer = nq.size();

	}

	static void printMap() {
		for (int arr[] : map)
			System.out.println(Arrays.toString(arr));
	}

}
