package dfs.n1707;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int[] color;
	static ArrayList<ArrayList<Integer>> link;
	static int V;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(Main.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			flag = true;
			color = new int[V + 1];
			link = new ArrayList<>();
			
			for (int i = 0; i <= V; i++) {
				link.add(new ArrayList<Integer>());
			}

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				link.get(x).add(y);
				link.get(y).add(x);
			}

			for (int i = 1; i < V + 1; i++) {
				// 이분 그래프가 아니면 반복문 탈출
				if (!flag)
					break;

				// 방문하지 않은 정점에 대해서 탐색 수행
				if (color[i] == 0) {

					dfs(i, 1);
				}
			}

			if (flag)
				System.out.println("YES");
			else
				System.out.println("NO");

		}
	}

	public static void dfs(int idx, int c) {
		color[idx] = c;

		
		for (int i : link.get(idx)) {

			if (color[i] == c) {
				flag = false;
				return;
			}

			if (color[i] == 0) {
				dfs(i, -c);
			}

		}
	}

}
