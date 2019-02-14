package n6485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setIn(Solution.class.getResourceAsStream("s_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scan = new Scanner(System.in);

		// int T = Integer.parseInt(br.readLine());
		int T = scan.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// int N = Integer.parseInt(br.readLine());
			int N = scan.nextInt();
			int bus[][] = new int[N][2];

			StringTokenizer st;

			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine());

//				bus[i][0] = Integer.parseInt(st.nextToken());
//				bus[i][1] = Integer.parseInt(st.nextToken());

				bus[i][0] = scan.nextInt();
				bus[i][1] = scan.nextInt();

			}

			// int P = Integer.parseInt(br.readLine());
			int P = scan.nextInt();

			int stops[] = new int[50001];
			int showStop[] = new int[P];

			for (int i = 0; i < P; i++) {
				showStop[i] = scan.nextInt();
			}

			for (int i = 0; i < N; i++) {
				int A = bus[i][0];
				int B = bus[i][1];

				for (int j = A; j <= B; j++) {

					stops[j]++;
				}

			}

			StringBuilder sb = new StringBuilder();

			sb.append(String.format("#%d", tc));

			for (int i = 0; i < P; i++) {

				sb.append(" ");
				sb.append(stops[showStop[i]]);

			}

			System.out.println(sb);
		}

	}
}
