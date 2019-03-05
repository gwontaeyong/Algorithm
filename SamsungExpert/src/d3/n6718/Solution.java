package d3.n6718;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setIn(Solution.class.getResourceAsStream("s_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int num = Integer.parseInt(br.readLine());

			num /= 100;
			// System.out.println(num);
			int level = 0;
			int divi = 10;

			while (num != 0) {
				level++;
				num /= divi;
				// divi *=10;
			}

			level = (level > 5) ? 5 : level;

			bw.write(String.format("#%d %d\n", tc, level));
			bw.flush();
		}

	}

}
