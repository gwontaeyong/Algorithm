package n6057;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("src/data/input_6057.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			// 각 간선의 유무를 저장할 배열
			int map[][] = new int[N + 1][N + 1];

			// 간선 저장
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[x][y] = 1;
				map[y][x] = 1;
			}

			int count = 0;

			for (int i = 1; i <= N; i++) {
				for (int j = i + 1; j <= N; j++) {
					if (map[i][j] == 0)
						continue;

					for (int k = j + 1; k <= N; k++) {
						if (map[i][k] == 0)
							continue;
						if (map[j][k] == 0)
							continue;

						count++;
					}
				}
			}

			System.out.format("#%d %d", tc, count);

		}
	}
}
