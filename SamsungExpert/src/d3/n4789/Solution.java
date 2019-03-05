package d3.n4789;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_4789.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			String people[] = br.readLine().split("");
			// �ڼ��� ģ�����
			int clap = Integer.parseInt(people[0]);// �����ؼ� �ڼ��� ġ�� ��� �߰�

			int answer = 0;// �ʿ��� ����� ��

			for (int i = 1; i < people.length; i++) {

				// �ּ� �ڼ����� ���� �ڼ��� ���� ���
				if (clap < i) {
					answer++;// ����� �߰��ϰ�
					clap++;// �ڼ��߰�
				}

				// �ڼ� ���� ������ �߰��� �Ͼ�� �ڼ� �߰�
				clap += Integer.parseInt(people[i]);

			}

			StringBuilder sb = new StringBuilder();
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(answer);
			System.out.println(sb);

		}
	}

}
