package d3.n6485;

import java.util.Scanner;

public class Answer {

	static int[] result;

	public static void main(String[] args) {

		System.setIn(Solution.class.getResourceAsStream("s_input.txt"));
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();// T
		for (int i = 0; i < tc; i++) {
			int num = sc.nextInt();// N
			range[] arr = new range[num];// bus
			for (int j = 0; j < num; j++) {
				int min = sc.nextInt();// A
				int max = sc.nextInt();// B
				arr[j] = new range(min, max);
			}
			int loc = sc.nextInt();// P

			result = new int[loc];// bus

			for (int j = 0; j < loc; j++) {
				int number = sc.nextInt();
				int tmp = 0;
				for (int k = 0; k < num; k++) {
					if (number >= arr[k].min && number <= arr[k].max) {
						tmp++;
					}
				}
				result[j] = tmp;
			}
			System.out.printf("#%d ", i + 1);
			for (int j = 0; j < result.length; j++) {
				System.out.printf("%d ", result[j]);
			}
			System.out.println();
		}
	}
}

class range {
	int min;
	int max;

	public range(int min, int max) {
		this.min = min;
		this.max = max;
	}
}