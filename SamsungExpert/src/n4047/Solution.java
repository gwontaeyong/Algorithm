package n4047;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_4047.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			// 카드종류별 카드 갯수를 배열에 저장
			// 1 = S , 2 = D, 3 = H, 4 = C
			int cards[][] = new int[4][14];

			String line = br.readLine();

			for (int i = 0; i < line.length(); i += 3) {
				int shape = line.charAt(i);
				int num = Integer.parseInt(line.substring(i + 1, i + 3));

				if (shape == 'S') {
					shape = 0;
				} else if (shape == 'D') {
					shape = 1;
				} else if (shape == 'H') {
					shape = 2;
				} else if (shape == 'C') {
					shape = 3;
				}

				// 카드 번호별 갯수 카운트
				if (cards[shape][num] == 0) {
					cards[shape][num]++;
				} else {
					// 중복으로 받으면 0번을 1로 변경
					cards[shape][0] = 1;
					// 에러이므로 나머지 카드 검색 불필요
					break;
				}

			}

			StringBuilder sb = new StringBuilder();
			sb.append("#");
			sb.append(test_case);

			// 출력
			for (int i = 0; i < 4; i++) {
				// 에러일 경우
				if (cards[i][0] != 0) {
					sb = new StringBuilder();
					sb.append("#");
					sb.append(test_case);
					sb.append(" ");
					sb.append("ERROR");
					break;
				} else {
					// 에러가 없을 경우
					int count = 0;

					for (int j = 1; j < 14; j++) {
						count += cards[i][j];
					}

					count = 13 - count;
					sb.append(" ");
					sb.append(count);

				}
			}

			System.out.println(sb);

		}
	}
}
