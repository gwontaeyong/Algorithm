package bfs.n16954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int answer = 0;
	// left right down up left-up right-up left-down right-down
	static int dx[] = { 0, -1, 1, 0, 0, -1, 1, -1, 1 };
	static int dy[] = { 0, 0, 0, -1, 1, -1, -1, 1, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(Main.class.getResourceAsStream("input.txt"));//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char map[][] = new char[8][8];
		boolean check[][] = new boolean[8][8];

		for (int i = 0; i < 8; i++) {
			char line[] = br.readLine().toCharArray();
			map[i] = line;
		}

		bfs(map, new boolean[8][8]);
		System.out.println(answer);

	}

	static void bfs(char map[][], boolean check[][]) {

		Queue<Data> queue = new LinkedList<>();
		check[7][0] = true;

		queue.add(new Data(0, 7, 0));
		int depth = 0;

		while (!queue.isEmpty()) {

			Data temp = queue.poll();

			int x = temp.x;
			int y = temp.y;

			// find out gate.
			if (x == 7 && y == 0) {
				answer = 1;
				break;
			}

			// after move the wall is move to down.
			if (depth != temp.depth) {
				depth = temp.depth; // update depth
				
				//check from bottom.
				for (int j = 7; j >= 0; j--) {
					for (int i = 0; i < 8; i++) {
						if (map[j][i] == '#') {// if find wall

							map[j][i] = '.'; // make to ground.

							if (j != 7) { // if the wall is not in last floor.
								map[j + 1][i] = '#';// move to down.
							}

						}
					}
				}

				printMap(map);// print map for debug
			}

			if (map[y][x] == '#') // if man meet the wall. that case is end.
				continue;

			// man go to in nine position.
			// left right down up left-up right-up left-down right-down
			for (int i = 0; i < dx.length; i++) {

				// move
				int nx = x + dx[i];
				int ny = y + dy[i];

				// if the position is out of range, it can't go.
				if (nx < 0 || nx > 7 || ny < 0 || ny > 7)
					continue;

				// it can be move if the position was not visited and not wall(ground).
				if (!check[ny][nx] && map[ny][nx] == '.') {
					map[ny][nx] = '@'; //check visited position for debug
					check[ny][nx] = true; // check visited
					queue.add(new Data(nx, ny, depth + 1)); // add next position in to queue.
				}

			}

		}
	}

	static class Data {
		int x;
		int y;
		int depth;

		Data(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

	static void printMap(char map[][]) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
