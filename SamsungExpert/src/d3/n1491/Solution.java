package d3.n1491;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		System.setIn(Solution.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			long ans = Long.MAX_VALUE;

			for (long l = 1; l <= N / 2; l++) {
				for (long m = l; m * l <= N; m++) {
					ans = Math.min(ans, A * Math.abs(l - m) + B * (N - m * l));
				}
			}

			System.out.println("#" + tc + " " + ans);

		}
	}
}
