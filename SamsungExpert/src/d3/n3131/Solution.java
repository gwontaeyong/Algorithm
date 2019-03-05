package d3.n3131;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int num = 1000000;
		long start = System.currentTimeMillis();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// boolean isPrime[] = new boolean[num + 1];

		// 에스토스테네스의 접근
		// 1 부터 n 의 제곱근까지 n 을 나누어 떨어지면 소수가 아니다.

		// 에스토스테네스의
		// 2 부터 n까지의 배수를 모두 소수가 아니라 저장한다.

//		for (int i = 2; i <= num; i++) {
//
//			if (isPrime[i] == false) {
//				for (int j = 2 * i; j <= num; j += i) {
//					isPrime[j] = true;
//				}
//			}
//
//		}

		StringBuilder sb = new StringBuilder();

//		for (int i = 2; i <= num; i++) {
//			if (!isPrime[i])
//				answer += i + " ";
//		}

		for (int i = 2; i <= num; i++) {

			boolean flag = true;

			for (int j = 2; j <= (int) Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}

			if (flag) {
				sb.append(i);
				sb.append(" ");
			}
		}

		// bw.write(sb.toString());
//		bw.newLine();

		System.out.println(sb);
		System.out.println(System.currentTimeMillis() - start);
	}

}
