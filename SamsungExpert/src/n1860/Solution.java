package n1860;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setIn(Solution.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			boolean customers[] = new boolean[11111 + 1];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				customers[Integer.parseInt(st.nextToken())] = true;
			}

			int bread = 0;
			int count = 0;
			int time = 0;

			boolean result = true;

			for (int i = 1; i < customers.length; i++) {

				if (count == N)
					break;

				time = (time + 1) % M;

				if (time == 0)
					bread += K;

				if (customers[i]) {

					if (bread == 0) {
						result = false;
						break;
					}
					bread--;
					count++;
				}

			}

			String answer = (result) ? "Possibe" : "Impossible";
			
			StringBuilder sb = new StringBuilder();
			sb.append("#");
			sb.append(tc);
			sb.append(" ");
			sb.append(answer);
			
			System.out.println(sb);
		}

	}

}
