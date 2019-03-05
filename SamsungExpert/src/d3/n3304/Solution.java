package d3.n3304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int map[][];
	static int check[];
	static int answer;

	// L R U D
	static int direction[][] = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {

		System.setIn(Solution.class.getResourceAsStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			char A[] = st.nextToken().toCharArray();
			char B[] = st.nextToken().toCharArray();

			int count = 0;

			char Long[];
			char Short[];

			if (A.length > B.length) {
				Long = A;
				Short = B;
			} else {
				Long = B;
				Short = A;
			}

			int shortIdx = 0;

			outer: for (int i = 0; i < Long.length; i++) {

				for (int j = shortIdx; j < Short.length; j++) {
					if (Long[i] == Short[j]) {
						System.out.println(Short[j]);
						count++;
						shortIdx = j + 1;
						continue outer;
					}
				}

			}
			System.out.println(count);
		}
	}

}
