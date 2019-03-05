package bfs.n1260.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static String result = "";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(Main.class.getResourceAsStream("input.txt"));//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		boolean map[][] = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = true;
		}

		// recursiveDFS(map, new boolean[N + 1], S, 0, N);
		System.out.println(result);
		bfs(map, new boolean[N + 1], S, N);

	}

	public static void dfs(boolean map[][], boolean check[], int S, int N) {

		Stack<Integer> stack = new Stack<>();

		StringBuilder sb = new StringBuilder();
		sb.append(S + " ");

		stack.push(S);

		while (!stack.isEmpty()) {

			int temp = stack.pop();
			
			for(int i = 1; i < N; i++) {
				
			}
			
		}
	}

	public static void bfs(boolean map[][], boolean check[], int S, int N) {

		StringBuilder sb = new StringBuilder();

		check[S] = true;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(S);

		while (!queue.isEmpty()) {
			int temp = queue.poll();
			sb.append(temp + " ");

			for (int i = 1; i < N + 1; i++) {
				if (map[temp][i] && !check[i]) {
					check[i] = true;
					queue.add(i);
				}
			}
		}

		System.out.println(sb);

	}
}
