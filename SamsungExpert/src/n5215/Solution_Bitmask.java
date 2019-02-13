package n5215;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Bitmask {
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_5215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			int gredient[][] = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				gredient[i][0] = Integer.parseInt(st.nextToken());
				gredient[i][1] = Integer.parseInt(st.nextToken());
			}

			/**
			 * 비트 마스
			 */

			int max = 0;

			for (int i = 0; i < (1 << N); i++) {
				// 경우의수

				int score = 0;
				int clore = 0;
				boolean flag = true;

				for (int j = 0; j < N; j++) {

					if ((i & (1 << j)) != 0) {
						score += gredient[j][0];
						clore += gredient[j][1];
					}

				}

				if (clore <= L) {
					max = (max > score) ? max : score;
				}

			}

			System.out.println(max);
		}
	}
}
