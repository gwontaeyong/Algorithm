package d3.n4522;

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

			String line = br.readLine();
			StringBuilder sb = new StringBuilder();

			sb.append(String.format("#%d ", tc));

			if (solve(line)) {
				sb.append("Exist");
			} else {
				sb.append("Not Exist");
			}

			System.out.println(sb);
		}

	}

	public static boolean solve(String line) {

		int length = line.length();
		String front;
		String back;

		int mid = line.length() / 2;

		if (length % 2 == 0) {

			front = line.substring(0, mid);
			back = line.substring(mid, length);

		} else {

			front = line.substring(0, mid);
			back = line.substring(mid + 1, length);
		}

		for (int i = 0; i < mid; i++) {

			char frontChar = front.charAt(i);
			char backChar = back.charAt(mid - 1 - i);

			if (frontChar == '?' || backChar == '?') {
				continue;
			}

			if (frontChar != backChar)
				return false;
			else {
				System.out.println(frontChar);
				System.out.println(backChar);
			}
		}

		return true;
	}

}
