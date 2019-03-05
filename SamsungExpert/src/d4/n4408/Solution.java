package d4.n4408;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		System.setIn(Solution.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int corridor[] = new int[201];
			StringTokenizer st;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				int startCordi = findCordi(start);
				int endCordi = findCordi(end);
				
				if(startCordi > endCordi) {
					int temp = startCordi;
					startCordi = endCordi;
					endCordi = temp;
				}
				for (int j = startCordi; j <= endCordi; j++) {
					corridor[j]++;
				}
			}

			int max = corridor[0];

			for (int i = 1; i < corridor.length; i++) {
				if (corridor[i] > max)
					max = corridor[i];
			}

			System.out.println(String.format("#%d %d", tc, max));
		}
	}

	public static int findCordi(int n) {
		if (n % 2 == 0) {
			return n / 2;
		} else {
			return (n + 1) / 2;
		}
	}
}
