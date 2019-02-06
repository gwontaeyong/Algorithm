package n6692;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_6692.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			int n = Integer.parseInt(br.readLine());
			double sum = 0;

			for (int i = 0; i < n; i++) {
				String line[] = br.readLine().split(" ");

				sum += Double.parseDouble(line[0]) * Double.parseDouble(line[1]);
			}

			System.out.println(String.format("#%d %.6f", test_case, sum));

		}

	}

}
