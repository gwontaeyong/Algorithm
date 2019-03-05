package d3.n5162;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_5162.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			String line = br.readLine();

			StringTokenizer st = new StringTokenizer(line, " ");

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			// 값이 싼 빵을 먼저 다 사고 나서 나머지 돈으로 더 비싼 빵을 산다.
			int firstBread = (A > B) ? B : A;
			int secondBread = (A > B) ? A : B;

			int count = 0;

			// 첫번째 빵 구매
			if (firstBread <= C) {
				count = C / firstBread;
				C %= firstBread;
				
				if(secondBread <= C) {
					count = C / secondBread;
				}
			}

			//

			System.out.println("#" + (test_case + 1) + " " + count);

		}
	}

}
