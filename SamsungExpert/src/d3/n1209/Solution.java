package d3.n1209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("src/data/input_1209.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			int test_case = Integer.parseInt(br.readLine());
			int map[][] = new int[100][100];
			int max = 0;
			int sum = 0;

			// 데이터 저장
			for (int j = 0; j < 100; j++) {
				String line = br.readLine();

				StringTokenizer st = new StringTokenizer(line, " ");

				for (int k = 0; k < 100; k++) {

					int data = Integer.parseInt(st.nextToken());

					map[j][k] = data;
				}
			}

			for (int j = 0; j < 100; j++) {

				for (int k = 0; k < 100; k++) {
					sum += map[j][k];
				}

				max = (max > sum) ? max : sum;
				sum = 0;
			}
			for (int j = 0; j < 100; j++) {

				for (int k = 0; k < 100; k++) {
					sum += map[k][j];
				}

				max = (max > sum) ? max : sum;
				sum = 0;
			}

			for (int j = 0; j < 100; j++) {
				sum += map[j][j];
			}

			max = (max > sum) ? max : sum;
			sum = 0;

			for (int j = 0; j < 100; j++) {
				sum += map[j][99 - j];
			}

			max = (max > sum) ? max : sum;
			sum = 0;

			String answer = "#";
			StringBuilder sb = new StringBuilder();
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(max);
			System.out.println(sb);

		}

	}

}
