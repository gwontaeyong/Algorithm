package d3.n6853;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_6853.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			String line[] = br.readLine().split(" ");

			int x1 = Integer.parseInt(line[0]);
			int y1 = Integer.parseInt(line[1]);
			int x2 = Integer.parseInt(line[2]);
			int y2 = Integer.parseInt(line[3]);

			int outside = 0;
			int inside = 0;
			int onside = 0;

			int N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {

				line = br.readLine().split(" ");

				int x = Integer.parseInt(line[0]);
				int y = Integer.parseInt(line[1]);

				// outside

				if ((x < x1 || x > x2) || (y < y1 || y > y2)) {
					outside++;
				} else if ((x > x1 && x < x2) && (y > y1 && y < y2)) {
					inside++;
				} else {
					onside++;
				}

			}
			System.out.println("#" + test_case + " " + inside + " " + onside + " " + outside);
		}

	}
}
