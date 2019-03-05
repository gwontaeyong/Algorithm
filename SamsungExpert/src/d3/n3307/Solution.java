package d3.n3307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(Solution.class.getResourceAsStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int arr[] = new int[N + 1];
			int dp[] = new int[N + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				arr[i + 1] = Integer.parseInt(st.nextToken());
			}

			dp[1] = 1;

			for (int i = 2; i <= N; i++) {
				if (arr[i] >= arr[i - 1]) {
					dp[i] = dp[i-1] + 1;
				} else {
					dp[i] = dp[i - 1];
				}
			}

			System.out.println("#"+tc+" "+dp[N]);
		}

	}

}
