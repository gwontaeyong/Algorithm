package d3.n1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int max;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(Solution.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			max = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			String card = st.nextToken();
			char cards[] = card.toCharArray();
			int change = Integer.parseInt(st.nextToken());
			int n = cards.length;

			solve(cards, new boolean[n], 0, change, n);
			System.out.format("#%d %d\n", tc, max);

		}

	}

	public static void solve(char card[], boolean check[], int depth, int change, int n) {

		if (depth == change) {

			int sum = 0;

			for (int i = 0; i < n; i++) {
				sum = sum * 10 + (card[i] - '0');

			}

			max = (max > sum) ? max : sum;

			return;
		}

		if (depth == n - 2) {
			if ((change - depth) % 2 != 0)
				swap(card, depth, depth + 1);
			solve(card, check, change, change, n);
			return;
		}

		for (int j = 0; j < n; j++) {
			for (int i = j + 1; i < n; i++) {

				swap(card, i, j);
				solve(card, check, depth + 1, change, n);
				swap(card, i, j);

			}
		}

	}

	public static void swap(char arr[], int i, int j) {

		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
