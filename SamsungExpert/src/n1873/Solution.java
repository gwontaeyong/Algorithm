package n1873;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_2817.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			int x = 0;
			int y = 0;

			String map[][] = new String[H][W];

			for (int h = 0; h < H; h++) {
				st = new StringTokenizer(br.readLine());
				for (int w = 0; w < W; w++) {
					map[h][w] = st.nextToken();
				}
			}
		}
	}
}
