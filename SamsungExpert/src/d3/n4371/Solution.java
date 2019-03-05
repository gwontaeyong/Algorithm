package d3.n4371;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_4371.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());

			int[] funs = new int[N];

			// �迭�� �谡 ���� ������ ����
			for (int i = 0; i < N; i++) {
				funs[i] = Integer.parseInt(br.readLine());
			}

			// �� �������� �������� ���� ������ ���Ͽ�
			// �� ������ ��� ������ ��� �ϳ��� ���� �����Ѵ�.
			for (int i = 1; i < N; i++) {
				if (funs[i] < 0)
					continue;
				int interval1 = funs[i] - 1;// �����Ϸκ��� ����
				for (int j = i + 1; j < N; j++) {
					if (funs[j] < 0)
						continue;
					int interval2 = funs[j] - 1;// �����Ϸκ����� ����
					if (interval2 % interval1 == 0) { // ��� ������ ��� �ϳ��� ��� ���
						funs[j] = -1;// �ϳ��� ��� �νĵ� ��� ���� �ݺ����� ���� �Ѵ�.
					}
				}
			}
			int count = 0;
			for (int i = 1; i < N; i++) {
				if (funs[i] > 0)// �ݺ��ؼ� ���Դ� �������� -1�� �� �ִ�.
					count++;
			}
			System.out.format("#%d %d\n", test_case, count);
		}
	}
}
