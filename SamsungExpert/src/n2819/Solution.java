package n2819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

import java.util.Map;

public class Solution {

	// l r u d
	static int direction[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int map[][];
	static Map<String, Boolean> check;
	static int count = 0;

	public static void main(String[] args) throws IOException {

		System.setIn(Solution.class.getResourceAsStream("s_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			check = new HashMap<>();
			map = new int[4][4];
			count = 0;
			for (int i = 0; i < 4; i++) {
				String line[] = br.readLine().split(" ");
				for (int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}

			solve(0, "");

			System.out.println(count);

		}

	}

	public static void solve(int count, String num) {

		if (count == 7) {

			if (!check.containsKey(num)) {
				count++;
				check.put(num, true);
			}

			return;
		}

		for (int i = 0; i < 4; i++) {// i

			for (int j = 0; j < 4; j++) {// j

				for (int k = 0; k < 4; k++) { // 4개의 방향

					int I = i + direction[k][0];
					int J = j + direction[k][1];

					if (I >= 0 && I < 4 && J >= 0 && J < 4) {

						solve(count + 1, num += map[i][j]);

					} 

				}

			}

		}

	}
}
