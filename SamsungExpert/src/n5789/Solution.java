package n5789;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_5789.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			String line[] = br.readLine().split(" ");

			int N = Integer.parseInt(line[0]);
			int Q = Integer.parseInt(line[1]);

			int arr[] = new int[N + 1];

			for (int i = 1; i <= Q; i++) {
				line = br.readLine().split(" ");

				int L = Integer.parseInt(line[0]);
				int R = Integer.parseInt(line[1]);

				for (int j = L; j <= R; j++) {
					arr[j] = i;
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#");
			sb.append(test_case);
			for (int i = 1; i <= N; i++) {
				sb.append(" ");
				sb.append(arr[i]);

			}
			System.out.println(sb);

		}
	}
}
