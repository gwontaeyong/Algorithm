package bfs.n7576_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Data {
		int n;
		int m;
		int time;

		public Data(int n, int m, int time) {
			// TODO Auto-generated constructor stub
			this.n = n;
			this.m = m;
			this.time = time;
		}

	}

	public static void main(String[] args) throws IOException {

		System.setIn(Main.class.getResourceAsStream("input_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int dm[] = { -1, 1, 0, 0 };
		int dn[] = { 0, 0, -1, 1 };

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int map[][] = new int[N][M];
		boolean check[][] = new boolean[N][M];

		Queue<Data> queue = new LinkedList<>();

		for (int n = 0; n < N; n++) {

			st = new StringTokenizer(br.readLine());

			for (int m = 0; m < M; m++) {

				int val = Integer.parseInt(st.nextToken());
				map[n][m] = val;

				if (val == 1) {
					queue.add(new Data(n, m, 0));
					check[n][m] = true;
				}
				
				if(val == -1)
					check[n][m] = true;
			}
		}

		int time = 0;

		while (!queue.isEmpty()) {
			Data temp = queue.poll();

			if (time < temp.time)
				time = temp.time;

			for (int i = 0; i < 4; i++) {
				int nN = temp.n + dn[i];
				int nM = temp.m + dm[i];

				if (nN < 0 || nN >= N || nM < 0 || nM >= M)
					continue;

				if (map[nN][nM] == -1 || check[nN][nM])
					continue;

				map[nN][nM] = 1;
				check[nN][nM] = true;
				queue.add(new Data(nN, nM, temp.time + 1));

			}
		}

		for (boolean[] arr : check) {
			for (boolean flag : arr) {
				if (!flag) {
					time = -1;
					break;
				}
			}
		}

		System.out.println(time);

	}
}
