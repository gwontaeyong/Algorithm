package d3.n5213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static long[] arr = new long[1000001];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setIn(Solution.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		solve();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			long result = 0;
			result = arr[R] - arr[L - 1];

			System.out.println(String.format("#%d %d", tc, result));

		}
	}

	// 1 2 3 4 5 6 7 8 9 10
//1    1 1 1 1 1 1 1 1 1 1 
//3        3     3     3  
//5            5         5
//6              6
//7                7
//8                  8 
//9                    9
//10  
	private static void solve() {

		// 약수 배열로 만들기
		for (int i = 1; i <= 1000000; i += 2) {
			for (int j = i; j <= 1000000; j += i) {
				arr[j] += i;
			}
		}

		// 이전 까지의 숫자들의 약수의 합으로 만들기
		for (int i = 1; i <= 1000000; i++) {
			arr[i] += arr[i - 1];
		}

	}
}
