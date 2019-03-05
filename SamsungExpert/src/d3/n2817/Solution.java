package d3.n2817;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static int count;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_2817.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int arr[] = new int[N];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			search(0, 0, K, arr);

			System.out.format("#%d %d\n", test_case, count);

		}
	}

	// ���� ����Լ�

	public static void search(int sum, int idx, int k, int arr[]) {
		if (sum > k) {
			return;
		}

		if (sum == k) {
			count++;
			return;
		}

		if (idx >= arr.length)
			return;

		search(sum + arr[idx], idx + 1, k, arr);
		search(sum, idx + 1, k, arr);

	}
}
