package n3376;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static long padoban[] = new long[100 + 1];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("src/data/input_3376.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= 100; tc++) {

			int n = Integer.parseInt(br.readLine());
			// 초기 파도반 수열의
			int padobanInit[] = { 0, 1, 1, 1, 2, 2 };

			long answer;

			// 파도반 수열의 값을 저장하는 배열의1-5까지 초기
			for (int i = 1; i < padobanInit.length; i++) {
				padoban[i] = padobanInit[i];
			}

			// 파도반 수열을 구하는 함
			answer = getPadoban(n);

			System.out.format("#%d %d\n", tc, answer);

		}
	}

	public static long getPadoban(int n) {

		// 파도반수열의 값이 6보다 작을 경우 초기값 리
		if (n <= 5) {
			return padoban[n];
		} else {
			// 배열에 값이 없을 경우 탐색 시
			if (padoban[n] == 0) {
				// 파도반 수열의 규칙 f[n] = f[n-1] + f[n-5];
				long result = getPadoban(n - 1) + getPadoban(n - 5);
				// 값 저장
				padoban[n] = result;
				// 값 리턴
				return result;
			} else {
				return padoban[n];
			}
		}

	}

}
