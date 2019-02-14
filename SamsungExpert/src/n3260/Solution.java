package n3260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setIn(Solution.class.getResourceAsStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String line[] = br.readLine().split(" ");
			String strA = line[0];
			String strB = line[1];

			Stack<Character> stackA = new Stack<>();
			Stack<Character> stackB = new Stack<>();

			for (int i = 0; i < strA.length(); i++) {
				stackA.add(strA.charAt(i));
			}

			for (int i = 0; i < strB.length(); i++) {
				stackB.add(strB.charAt(i));
			}

			int rest = 0;
			int upper = 0;
			StringBuilder answer = new StringBuilder();

			while (!stackA.isEmpty() && !stackB.isEmpty()) {
				int a = stackA.pop() - '0';
				int b = stackB.pop() - '0';

				int sum = a + b + upper;

				if (sum > 9) {
					rest = sum - 10;
					upper = 1;
				} else if (sum == 10) {
					rest = 0;
					upper = 1;
				} else {
					rest = sum;
					upper = 0;
				}

				answer.append(rest);
			}

			String result;

			Stack<Character> last = (stackA.isEmpty()) ? stackB : stackA;

			if (stackA.isEmpty() && stackB.isEmpty()) {
				if (upper != 0)
					answer.append(upper);
			}

			while (!last.isEmpty()) {
				int a = last.pop() - '0';
				int sum = a + upper;

				if (sum > 9) {
					rest = sum - 10;
					upper = 1;
				} else if (sum == 10) {
					rest = 0;
					upper = 1;
				} else {
					rest = sum;
					upper = 0;
				}
				answer.append(rest);
			}

			if (upper != 0)
				answer.append(upper);
			
			StringBuilder sb = new StringBuilder();
			result = answer.toString();

			for (int i = result.length() - 1; i >= 0; i--) {
				sb.append(result.charAt(i));
			}

			System.out.format("#%d %s\n", tc, sb.toString());
		}

	}
}
