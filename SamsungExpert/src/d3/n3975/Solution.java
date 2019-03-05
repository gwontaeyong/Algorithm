package d3.n3975;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(Solution.class.getResourceAsStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			String line[] = br.readLine().split(" ");

			double aliceW = Integer.parseInt(line[0]);
			double aliceG = Integer.parseInt(line[1]);
			double bobW = Integer.parseInt(line[2]);
			double bobG = Integer.parseInt(line[3]);

			String result;

			if (aliceW / aliceG > bobW / bobG) {
				result = "ALICE";
			} else if (aliceW / aliceG == bobW / bobG) {
				result = "DRAW";
			} else {
				result = "BOB";
			}

			bw.write(String.format("#%d %s\n", tc, result));
			bw.flush();
		}
	}

}
