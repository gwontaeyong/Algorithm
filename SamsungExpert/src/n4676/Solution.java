package n4676;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_4676.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String line = br.readLine();

			int size = Integer.parseInt(br.readLine());

			int num[] = new int[line.length() + 1];

			String data[] = br.readLine().split(" ");

			for (int i = 0; i < size; i++) {
				num[Integer.parseInt(data[i])]++;
			}

			String answer = "";

			for (int i = 0; i <= line.length(); i++) {

				for (int m = num[i]; m > 0; m--) {
					answer += "-";
				}
				if (i == line.length()) {
					break;
				}
				answer += line.charAt(i);
			}

			System.out.println("#" + test_case + " " + answer);

		}
	}
}
