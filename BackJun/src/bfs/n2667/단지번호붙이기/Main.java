package bfs.n2667.단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	static class Node {
		int i;
		int j;

		Node(int i, int j) {
			this.i = i;
			this.j = j;

		}

		public String toString() {
			return i + " : " + j;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(Main.class.getResourceAsStream("input.txt"));//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] di = { 0, 0, -1, 1 };
		int[] dj = { -1, 1, 0, 0 };

		boolean map[][] = new boolean[N][N];

		for (int i = 0; i < N; i++) {

			char line[] = br.readLine().toCharArray();

			for (int j = 0; j < N; j++) {
				map[i][j] = (line[j] == '1') ? true : false;
			}
		}

		List<Integer> apart = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (map[i][j]) {// 집을 발견하면 단지 탐색을 시작한다.

					map[i][j] = false;
					int count = 1;

					Queue<Node> queue = new LinkedList<>();

					Node node = new Node(i, j);
					queue.add(node);

					while (!queue.isEmpty()) {

						Node temp = queue.poll();

						for (int k = 0; k < 4; k++) {
							int ni = temp.i + di[k];
							int nj = temp.j + dj[k];

							if (ni < 0 || ni >= N || nj < 0 || nj >= N)
								continue;

							if (map[ni][nj]) {
								count++;
								map[ni][nj] = false;
								queue.add(new Node(ni, nj));
							}
						}
					}

					apart.add(count);
				}
			}
		}

		Collections.sort(apart);

		System.out.println(apart.size());
		
		for(int i = 0; i < apart.size(); i++) {
			System.out.println(apart.get(i));
		}

	}

}
