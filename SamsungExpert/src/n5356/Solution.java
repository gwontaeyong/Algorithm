package n5356;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_5356.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int c = 1; c <= t; c++) {
			StringBuilder result = new StringBuilder();

			String[][] str = new String[5][15];

			for (int i = 0; i < 5; i++) {
				String[] temp = br.readLine().split("");
				for (int j = 0; j < temp.length; j++) {
					str[i][j] = temp[j];
				}
				for (int j = temp.length; j < 15; j++) {
					str[i][j] = "null";
				}
			}

			for (int j = 0; j < 15; j++) {
				for (int i = 0; i < 5; i++) {
					if (!str[i][j].equals("null"))
						result.append(str[i][j]);
				}
			}

			sb.append("#").append(c).append(" ").append(result).append("\n");
		}
		
		
		System.out.println(sb);
	}
}
