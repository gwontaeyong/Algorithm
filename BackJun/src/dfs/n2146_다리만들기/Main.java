package dfs.n2146_다리만들기;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static boolean visited[][];

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static int answer;
	static List<Node> list;
	static Queue<Node> q;

	public static class Node {
		int x;
		int y;
		int color;

		Node(int x, int y, int color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}

		public String toString() {
			return x + " : " + y + " color " + color;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(Main.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		list = new ArrayList<>();
		list.add(new Node(0, 0, 0));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		answer = 987654321;
		q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int color = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (map[i][j] == 0 || visited[i][j])
					continue;

				list.add(new Node(j, i, color));
				search(j, i, color);
				color++;
			}
		}

		System.out.println(answer);
	}

	public static void enlage(int color) {

		for (int i = 1; i < color; i++) {
			Node n = list.get(i);

			q = new LinkedList<>();
			q.add(n);

			while (!q.isEmpty()) {
				
				//Node
			}

		}
	}

	public static void search(int x, int y, int color) {

		q.add(new Node(x, y, color));

		while (!q.isEmpty()) {

			Node temp = q.poll();
			map[temp.y][temp.x] = color;
			visited[temp.y][temp.x] = true;

			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];

				if (!isRange(nx, ny) || visited[ny][nx])
					continue;

				if (map[ny][nx] == 0) {
					continue;
				}

				q.add(new Node(nx, ny, color));
			}
		}
	}

	public static boolean isRange(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		return true;
	}

}
