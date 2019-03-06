package bfs.n16918_범버맨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Bom {

		char c;
		int time;

		Bom() {
			this.c = '.';
			this.time = 1;
		}

		Bom(char c, int time) {
			this.c = c;
			this.time = time;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.valueOf(c) + time;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(Main.class.getResourceAsStream("input_2.txt"));//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int di[] = { 0, 0, -1, 1 };
		int dj[] = { -1, 1, 0, 0 };

		Bom map[][] = new Bom[N][M];

		for (int i = 0; i < N; i++) {
			char line[] = br.readLine().toCharArray();
			System.out.println(Arrays.toString(line));
			for (int j = 0; j < M; j++) {
				map[i][j] = new Bom(line[j], 1);
			}
		}

		
	}
}
