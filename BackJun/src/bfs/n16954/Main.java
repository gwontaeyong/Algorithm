package bfs.n16954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// System.setIn(Main.class.getResourceAsStream("input.txt"));//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char map[][] = new char[8][8];
		boolean check[][] = new boolean[8][8];

		int dx[] = { 0, -1, 1, 0, 0, -1, 1, -1, 1 };
		int dy[] = { 0, 0, 0, -1, 1, -1, 1, 1, -1 };

		for (int i = 0; i < 8; i++) {
			char line[] = br.readLine().toCharArray();
			map[i] = line;
		}

		Queue<Integer[]> queue = new LinkedList<>();

		check[7][0] = true;

		for (int i = 0; i < dx.length; i++) {

			int nx = 0 + dx[i];
			int ny = 7 + dy[i];

			// if find block or out of range
			if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8 || map[ny][nx] == '#')
				continue;

			check[ny][nx] = true;

			Integer temp2[] = { nx, ny };
			queue.add(temp2);
		}

		int answer = 0;

		while (!queue.isEmpty()) {
			Integer[] temp = queue.poll();

			int x = temp[0];
			int y = temp[1] - 1;

			if (x == 7 && y == 0) {
				answer = 1;
				break;
			}

			if (x < 0 || x >= 8 || y < 0 || y >= 8 || map[y][x] == '#' || check[y][x])
				continue;

			for (int i = 0; i < dx.length; i++) {

				int nx = x + dx[i];
				int ny = y + dy[i];

				// if find block or out of range
				if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8 || map[ny][nx] == '#' || check[y][x])
					continue;
				
				check[ny][nx] = true;
				
				Integer temp2[] = { nx, ny };
				queue.add(temp2);
			}
		}

		System.out.println(answer);

	}

}
