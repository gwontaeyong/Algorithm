package n3260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setIn(Solution.class.getResourceAsStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			String strA = br.readLine();
			String strB = br.readLine();
			int arrA[] = new int[9];
			int arrA[] = new int[9];

		}

		int count = 0;
		int ten = 10;

		while (Integer.MAX_VALUE / ten > 0) {
			count++;
			ten *= 10;
		}
		System.out.println(Integer.MAX_VALUE);
		System.out.println(count - 1);
	}
}
