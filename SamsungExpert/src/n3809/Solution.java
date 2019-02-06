package n3809;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_3809.txt"));
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Scanner scan = new Scanner(System.in);

		// int T = Integer.parseInt(br.readLine());
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			// int size = Integer.parseInt(br.readLine());
			// String data = br.readLine().replace(" ", "");
//			if (size > 20) {
//
//				for (int i = 0; i < size / 20 - 1; i++) {
//					data += br.readLine().replace(" ", "");
//				}
//			}

			int size = scan.nextInt();

			String data = "";

			for (int i = 0; i < size; i++) {
				data += scan.nextInt();
			}

		

			int min = -1;
			boolean check[];
			int range = 0;

			// 카드를 선택할 수 있는 모든 경우의 수를 검색한다.

			outer: for (int i = 1; i <= data.length(); i++) {

				// 1,10,100의자리 숫자 조합중 숫자의 존재를 체크하는 배
				check = new boolean[(int) Math.pow(10, i)];

				// 카드를 1,2,3..뽑는 경우의 수
				for (int j = 0; j <= data.length() - i; j++) {
					int temp = Integer.parseInt(data.substring(j, j + i));
					// System.out.println("temp " + temp);
					check[temp] = true;
				}

				// 카드 존재를 확인해서 존재하지 않는 경우가 발생할 경우에 종
				for (int j = range; j < check.length; j++) {
					if (!check[j]) {
						min = j;
						break outer;
					}
				}

				range = check.length;

			}

			System.out.println("#" + test_case + " " + min);

		}
	}
}
