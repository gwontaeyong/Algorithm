package d3.n1860;

import java.util.Scanner;

public class Answer {
	public static void main(String[] args) throws Exception {

		System.setIn(Solution.class.getResourceAsStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();// 붕어빵 시간
			int K = sc.nextInt();// 붕어빵 개수
			int[] timeTable = new int[11112];
			int[] customerArrivedTime = new int[N];
			boolean isImpossable = false;
			int fishBread = 0;
			for (int i = 0; i < N; i++) {
				customerArrivedTime[i] = sc.nextInt();
				timeTable[customerArrivedTime[i]]++;
				if (M > customerArrivedTime[i]) {
					isImpossable = true;
				}
			}
			if (!isImpossable) {
				boolean flag = true;
				for (int i = 0; i < timeTable.length; i++) {
					if (i == 0) {
						fishBread = 0;
					} else if (i % M == 0) {
						fishBread += K;
					}
					if (timeTable[i] > 0) {
						fishBread -= timeTable[i];
						if (fishBread < 0) {
							flag = false;
							break;
						}
					}
				}
				if (flag) {
					System.out.println("#" + test_case + " Possible");
				} else {
					System.out.println("#" + test_case + " Impossible");
				}
			} else {
				System.out.println("#" + test_case + " Impossible");
			}
		}
	}
}