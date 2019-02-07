package n4789;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_4789.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			String people[] = br.readLine().split("");
			// 박수를 친사람들
			int clap = Integer.parseInt(people[0]);// 자진해서 박수를 치는 사람 추가

			int answer = 0;// 필요한 사람의 수

			for (int i = 1; i < people.length; i++) {

				// 최소 박수보다 현재 박수가 작을 경우
				if (clap < i) {
					answer++;// 사람수 추가하고
					clap++;// 박수추가
				}

				// 박수 갯수 만족시 추가로 일어나는 박수 추가
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
