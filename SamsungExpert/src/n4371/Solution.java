package n4371;

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

			// 배열에 배가 들어온 일차를 저장
			for (int i = 0; i < N; i++) {
				funs[i] = Integer.parseInt(br.readLine());
			}

			// 각 일차별을 기준으로 다음 일차를 비교하여
			// 두 일차가 배수 관계일 경우 하나의 배라고 가정한다.
			for (int i = 1; i < N; i++) {
				if (funs[i] < 0)
					continue;
				int interval1 = funs[i] - 1;// 시작일로부터 간격
				for (int j = i + 1; j < N; j++) {
					if (funs[j] < 0)
						continue;
					int interval2 = funs[j] - 1;// 시작일로부터의 간격
					if (interval2 % interval1 == 0) { // 배수 관계일 경우 하나의 배로 취급
						funs[j] = -1;// 하나의 배로 인식될 경우 다음 반복에서 제외 한다.
					}
				}
			}
			int count = 0;
			for (int i = 1; i < N; i++) {
				if (funs[i] > 0)// 반복해서 들어왔던 일차에는 -1이 들어가 있다.
					count++;
			}
			System.out.format("#%d %d\n", test_case, count);
		}
	}
}
