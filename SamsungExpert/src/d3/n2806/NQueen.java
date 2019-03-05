package d3.n2806;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {

	private static int count;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_2806.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			// 2차원 배열이 필요하지 않다 1차원 배열로 가능하다.
			// boolean map[][] = new boolean[n][n];
			int n = Integer.parseInt(br.readLine());

			int map[][] = new int[n][n];

			count = 0;

			getQueen(map, 0, n);

			System.out.println("#" + test_case + " " + count);
		}

	}

	private static boolean isPromise(int map[][], int line, int i, int n) {

		// 위에서 아래로 검사 하는데

		// 세로 검사

		for (int j = 0; j < line; j++) {
			if (map[j][i] == 1)
				return false;
		}
		// 가로세로
		int left = i;
		int right = i;

		for (int j = line; j >= 0; j--) {
			
			if(left >= 0 && map[j][left] == 1)
				return false;
			
			if(right < n && map[j][right] == 1)
				return false;
			
			left--;
			right++;
			

		}
		
		return true;
	}

	private static void getQueen(int map[][], int line, int n) {
		// TODO Auto-generated method stub

		if (line == n) {
			count++;
		}

		/*
		 * 
		 * */

		for (int i = 0; i < n; i++) {
			if (isPromise(map, line, i, n)) {
				map[line][i] = 1;
				getQueen(map, line + 1, n);
				map[line][i] = 0;
			}
		}

	}

}
