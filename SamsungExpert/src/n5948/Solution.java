package n5948;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/data/input_5948.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int cards[] = new int[7];

			for (int i = 0; i < 7; i++) {
				cards[i] = Integer.parseInt(st.nextToken());
			}

			// 카드의 합을 저장할 셋 (중복을 없애기 위하여)
			Set<Integer> sums = new HashSet<>();

			for (int i = 0; i < 7; i++) {
				for (int j = i + 1; j < 7; j++) {
					for (int k = j + 1; k < 7; k++) {
						// 모든 경우의 수를 더하여 셋에 저장
						sums.add((cards[i] + cards[j] + cards[k]));

					}
				}
			}

			//셋의 리스트화
			List<Integer> list = new ArrayList<Integer>(sums);
			
			//정렬
			Collections.sort(list);

			int result = list.get(list.size() - 5);
			System.out.format("#%d %d\n", test_case, result);
		}

	}
}