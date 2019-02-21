
package n4615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		System.setIn(Solution.class.getResourceAsStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int dx[] = { -1, 1, 0, 0, -1, 1, -1, 1 };
		int dy[] = { 0, 0, -1, 1, -1, -1, 1, 1 };

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int map[][] = new int[N + 1][N + 1];

			map[N / 2 + 1][N / 2 + 1] = 2;
			map[N / 2 + 1][N / 2] = 1;
			map[N / 2][N / 2 + 1] = 1;
			map[N / 2][N / 2] = 2;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int stone = Integer.parseInt(st.nextToken());

				map[y][x] = stone;

				for (int j = 0; j < 8; j++) {

					int nx = x + dx[j];
					int ny = y + dy[j];

					int count = 0;

					while (nx <= N && nx > 0 && ny <= N && ny > 0) {

						if (map[ny][nx] == 0)
							break;

						if (map[ny][nx] == stone) {
							nx = x;
							ny = y;

							for (int k = 0; k < count; k++) {
								nx += dx[j];
								ny += dy[j];

								map[ny][nx] = stone;
							}
							break;
						}

						if (map[ny][nx] != stone) {
							count++;
						}

						nx += dx[j];
						ny += dy[j];

					}

				}

			}

			int black = 0;
			int white = 0;

			for (int[] arr : map) {
				for (int data : arr) {

					if (data == 1)
						black++;
					else if (data == 2)
						white++;
				}
			}
			System.out.println("#" + tc + " " + black + " " + white);

		}
	}
}
