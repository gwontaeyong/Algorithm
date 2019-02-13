package n1860;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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

			// boolean customers[] = new boolean[11111 + 1];
			int customers[] = new int[N];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				// customers[Integer.parseInt(st.nextToken())] = true;
				customers[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(customers);

			int bread = 0;
			int lastCharge = 0;
			boolean result = true;

			/*
			 * M초마다 K개의 빵이 생긴다.
			 */

			for (int i = 0; i < N; i++) {

				int chargeTime = customers[i] - lastCharge;// time customer come.

				if (chargeTime >= M) {
					int chargeNum = chargeTime / M;
					lastCharge += M * chargeNum;
					bread += K * chargeNum;
				}

				if (bread == 0) {
					result = false;
					break;
				}

				bread--;

			}

			String answer = (result) ? "Possible" : "Impossible";

			StringBuilder sb = new StringBuilder();
			sb.append("#");
			sb.append(tc);
			sb.append(" ");
			sb.append(answer);

			System.out.println(sb);
		}

	}

	public static void order(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

}
