package d3.n4698;

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

			StringTokenizer st = new StringTokenizer(br.readLine());

			int special = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());

			boolean primes[] = new boolean[last + 1];

			primes[1] = true;

			// 소수 확인
			for (int i = 2; i <= last; i++) {

				if (primes[i] == false) {
					for (int j = i + i; j <= last; j += i) {
						primes[j] = true;
					}
				}
			}

			int count = 0;

			for (int i = start; i <= last; i++) {

				if (!primes[i]) {
					int check = i;

					while (check != 0) {

						if (check % 10 == special) {
							count++;
							break;
						}

						check /= 10;
					}
				}
			}

			System.out.format("#%d %d\n", tc, count);

		}
	}
}
