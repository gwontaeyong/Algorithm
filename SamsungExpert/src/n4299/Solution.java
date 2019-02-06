package n4299;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_4299.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int D = 11;
		int H = 11;
		int M = 11;

		int date = 11 * 24 * 60 + 11 * 60 + 11;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			String time[] = br.readLine().split(" ");

			int d = Integer.parseInt(time[0]);
			int h = Integer.parseInt(time[1]);
			int m = Integer.parseInt(time[2]);

			d = d * 24 * 60;
			h = h * 60;

			int waiting = (m + h + d) - date;

			waiting = (waiting >= 0) ? waiting : -1;

			System.out.println("#" + test_case + " " + waiting);
		}
	}
}