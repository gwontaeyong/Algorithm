package n6808;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int gy[] = new int[9];
	static int iy[] = new int[9];
	static int gyWin;

	public static void main(String[] args) throws IOException {

		System.setIn(Solution.class.getResourceAsStream("s_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int fac9 = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1;

		for (int test_case = 1; test_case <= T; test_case++) {

			int gameNum = fac9;
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean check[] = new boolean[19];

			gyWin = 0;

			for (int i = 0; i < 9; i++) {
				int card = Integer.parseInt(st.nextToken());
				gy[i] = card;
				check[card] = true;// 규영이 카드
			}

			int temp = 0;

			for (int i = 1; i < 19; i++) {
				if (!check[i]) {// 남아있는 카드라면
					iy[temp] = i;
					temp++;
				}
			}

			doGame(0, new boolean[9], 0, 0);

			System.out.println(String.format("#%d %d %d", test_case, gyWin, gameNum - gyWin));

		}

	}

	public static void doGame(int depth, boolean check[], int gyScore, int iyScore) {

		if (depth == 9) {

			if (gyScore > iyScore)
				gyWin++;

			return;
		}

		for (int i = 0; i < 9; i++) {

			if (!check[i]) {
				check[i] = true;

				int sum = gy[depth] + iy[i];

				if (gy[depth] > iy[i]) {
					gyScore += sum;
				} else {
					iyScore += sum;
				}

				doGame(depth + 1, check, gyScore, iyScore);

				if (gy[depth] > iy[i]) {
					gyScore -= sum;
				} else {
					iyScore -= sum;
				}
				check[i] = false;

			}
		}

	}
}
