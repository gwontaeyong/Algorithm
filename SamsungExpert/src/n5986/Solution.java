package n5986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	static int count;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4 };
		int result[] = new int[3];

		System.setIn(Solution.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			count = 0;
			int N = Integer.parseInt(br.readLine());

			// 소수 배열 만들기

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
			
			for(int )
			dupleCombination(primes, 0, 0, N);
			System.out.println(count);
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
