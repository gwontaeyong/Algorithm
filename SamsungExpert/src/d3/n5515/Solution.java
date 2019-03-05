package d3.n5515;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {

		int LASTDAY[] = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int start_date = 4;

		System.setIn(new FileInputStream("src/data/input_5515.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String line = br.readLine();

			StringTokenizer st = new StringTokenizer(line, " ");

			int month = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());

			for (int j = 1; j < month; j++) {
				day += LASTDAY[j];
			}
//System.out.println(day);
			day += 4 -1 ;
			day %= 7;
			
			System.out.println("#" + (i + 1) + " " + day);

		}
	}
}
