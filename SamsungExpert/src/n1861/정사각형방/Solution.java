package n1861.정사각형방;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static class Struct {
		int startNum;
		int i;
		int j;
		int count;

		public Struct(int startNum, int i, int j) {
			// TODO Auto-generated constructor stub
			this.startNum = startNum;
			this.i = i;
			this.j = j;
			count = 1;

		}

		public String toString() {
			return startNum + " : " + count;
		}
	}

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(Solution.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int[N + 1][N + 1];

			for (int i = 1; i < N + 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 1; j < N + 1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = -1;
			int start = 0;

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {

					Struct st = new Struct(map[i][j], i, j);

					Queue<Struct> queue = new LinkedList<>();

					queue.add(st);

					while (!queue.isEmpty()) {

						Struct temp = queue.poll();

						if (max < temp.count) {
							max = temp.count;
							start = temp.startNum;
						} else if (max == temp.count) {
							start = (start > temp.startNum) ? temp.startNum : start;
						}

						for (int k = 0; k < 4; k++) {
							int ni = temp.i + dy[k];
							int nj = temp.j + dx[k];

							if (ni < 1 || ni > N || nj < 1 || nj > N) {
								continue;
							}

							if (map[temp.i][temp.j] + 1 == map[ni][nj]) {
								temp.i = ni;
								temp.j = nj;
								temp.count++;

								queue.add(temp);
							}

						}

					}

				}
			}

			System.out.println(String.format("#%d %d %d", tc, start, max));
		}
	}

}
