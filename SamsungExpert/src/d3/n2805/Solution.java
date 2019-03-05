package d3.n2805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {


			// map size 받
			int size = Integer.parseInt(br.readLine());

			// 농장물의 데이터 받
			int map[][] = new int[size][size];

			for (int j = 0; j < size; j++) {
				char data[] = br.readLine().toCharArray();

				for (int k = 0; k < data.length; k++) {
					map[j][k] = (int) data[k] - '0';
				}

			}

			// ^ 와 같은 모양의 윗부분 탐색

			int sum = 0;

			for (int j = 0; j <= size / 2; j++) {
				for (int col = j; col < size - j; col++) {
					sum += map[size / 2 - j][col];
				}
			}

			// 와 같은 모양의 윗부분 탐색

			for (int j = 1; j <= size / 2; j++) {
				for (int col = j; col < size - j; col++) {
					sum += map[j + size / 2][col];
				}
			}
			System.out.println("#"+(i+1)+" "+sum);
		}
	}
}
