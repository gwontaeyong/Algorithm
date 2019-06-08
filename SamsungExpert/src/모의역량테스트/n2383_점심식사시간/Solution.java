package 모의역량테스트.n2383_점심식사시간;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static PriorityQueue<Integer> readyQ[];
	public static Queue<Integer> downQ[];

	public static int N;
	public static int pn;
	public static int p[][];
	public static int gate[][];

	public static int map[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(Solution.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			gate = new int[2][2];
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			readyQ = new PriorityQueue[2];
			downQ = new LinkedList[2];
			int gateIdx = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());

					map[i][j] = n;

					if (n == 1)
						pn++;
					else if (n != 0) {
						gate[gateIdx][0] = j;
						gate[gateIdx][1] = i;
						gateIdx++;
					}
				}
			}

			p = new int[pn][2];
			int pIdx = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						p[pIdx][0] = j;
						p[pIdx][1] = i;
						pIdx++;
					}

				}
			}

			// 경우의수 탐색
			dfs(new int[pn], pn, 0);

		}
	}

	public static void dfs(int result[], int n, int idx) {
		if (idx == n) {

			//
			System.out.println(Arrays.toString(result));
			return;
		}

		result[idx] = 0;
		dfs(result, n, idx + 1);
		result[idx] = 1;
		dfs(result, n, idx + 1);
	}

}
