package n5215;

import java.util.Scanner;

class Solution {

	static int max;
	static int limit;
	static int[] ingredient;
	static int[] preference;
	static int[] calorie;

	public static void main(String args[]) throws Exception {

		System.setIn(Solution.class.getResourceAsStream("sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			limit = sc.nextInt();

			ingredient = new int[N];
			preference = new int[N];
			calorie = new int[N];

			max = 0;

			for (int i = 0; i < N; i++) {
				ingredient[i] = i;
				preference[i] = sc.nextInt();
				calorie[i] = sc.nextInt();
			}

			solve(N, 0, 0, 0);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(max);
			System.out.println(sb);
		}

	}

	public static void solve(int n, int idx, int preSum, int calSum) {

		if (calSum > limit) {
			return;
		}

		if (idx == n) {

			max = (max > preSum) ? max : preSum;
			return;
		}

		solve(n, idx + 1, preSum + preference[idx], calSum + calorie[idx]);
		solve(n, idx + 1, preSum, calSum);
	}
}