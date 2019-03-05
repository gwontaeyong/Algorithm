package d3.n1221;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_1221.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			String line = br.readLine();

			StringTokenizer st = new StringTokenizer(line, " ");

			String index = st.nextToken();
			int len = Integer.parseInt(st.nextToken());

			String nums[] = new String[len];

			line = br.readLine();
			st = new StringTokenizer(line, " ");

			for (int i = 0; i < len; i++) {
				nums[i] = st.nextToken();
			}

			boubleSortStr(nums);

			System.out.println(index);
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();

		}

	}

	public static int getNum(String str) {
		String strNum[] = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };

		for (int i = 0; i < strNum.length; i++) {
			if (strNum[i].equals(str))
				return i;
		}

		return -1;
	}

	public static void boubleSortStr(String arr[]) {

		for (int j = 1; j < arr.length; j++) {
			for (int i = 0; i < arr.length - j; i++) {
				if (getNum(arr[i]) > getNum(arr[i + 1])) {
					String temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}
}
