package d3.n4047;

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

			// ī�������� ī�� ������ �迭�� ����
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

				// ī�� ��ȣ�� ���� ī��Ʈ
				if (cards[shape][num] == 0) {
					cards[shape][num]++;
				} else {
					// �ߺ����� ������ 0���� 1�� ����
					cards[shape][0] = 1;
					// �����̹Ƿ� ������ ī�� �˻� ���ʿ�
					break;
				}

			}

			StringBuilder sb = new StringBuilder();
			sb.append("#");
			sb.append(test_case);

			// ���
			for (int i = 0; i < 4; i++) {
				// ������ ���
				if (cards[i][0] != 0) {
					sb = new StringBuilder();
					sb.append("#");
					sb.append(test_case);
					sb.append(" ");
					sb.append("ERROR");
					break;
				} else {
					// ������ ���� ���
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
