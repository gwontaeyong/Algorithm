package n5986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	static int C;
	static int N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4 };

		System.setIn(Solution.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			C = 0;
			N = Integer.parseInt(br.readLine());

			boolean primes[] = new boolean[N + 1];
			int primeNum = 0;

			for (int i = 2; i <= N; i++) {

				if (primes[i] == false) {
					primeNum++;
					for (int j = i * 2; j <= N; j += i) {
						primes[j] = true;
					}

				}
			}

			int prime[] = new int[primeNum];
			int primeIdx = 0;

			for (int i = 2; i < primes.length; i++) {

				if (!primes[i])
					prime[primeIdx++] = i;

			}

			dupleCombination(prime, 0, 0, 0);

			System.out.format("#%d %d\n", tc, C);
		}

	}

	public static void dupleCombination(int primes[], int depth, int count, int sum) {

		if (count == 3) {

			if (sum == N) {
				C++;
			}

			return;
		}

		if (depth == primes.length)
			return;

		if (sum < N) {
			dupleCombination(primes, depth + 1, count, sum);
			dupleCombination(primes, depth, count + 1, sum + primes[depth]);
		}

	}

	public static void dupleCombination(int arr[], int result[], int count) {

		for (int i = 0; i < arr.length; i++) {
			if (count == arr.length) {
				System.out.println(Arrays.toString(result));
				return;
			}
			result[count] = arr[i];
			dupleCombination(arr, result, count + 1);
		}

	}

}
