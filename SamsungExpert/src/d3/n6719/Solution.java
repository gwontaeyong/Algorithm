package d3.n6719;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Solution {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_6719.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			double score = 0;
			String line[] = br.readLine().split(" ");

			int N = Integer.parseInt(line[0]);
			int K = Integer.parseInt(line[1]);

			String class_score[] = br.readLine().split(" ");
			Double class_score_int[] = new Double[N];

			for (int i = 0; i < N; i++) {
				class_score_int[i] = Double.parseDouble(class_score[i]);
			}

			Arrays.sort(class_score_int, Collections.reverseOrder());

			// System.out.println(Arrays.toString(class_score_int));

			for (int i = 0; i < K; i++) {
				score += class_score_int[i] * Math.pow(0.5, i + 1);
			}

			System.out.format("#%d %6f\n", test_case, score);

		}
	}
}
