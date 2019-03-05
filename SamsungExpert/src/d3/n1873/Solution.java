package d3.n1873;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static char positions[] = { '<', '>', '^', 'v' };
	static int direction[] = new int[2]; // 전차의 방향을 체크하는 배열
	static int H;
	static int W;
	static char map[][];
	static char state;
	static int x;
	static int y;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/data/input_1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H][W];

			for (int h = 0; h < H; h++) {
				String line = br.readLine();

				for (int w = 0; w < W; w++) {
					map[h][w] = line.charAt(w);

					if (isPosition(map[h][w])) {
						state = map[h][w];
						x = w;
						y = h;
					}

				}

			}

			int N = Integer.parseInt(br.readLine());

			char cmds[] = br.readLine().toCharArray();

			for (char cmd : cmds) {
				doCMD(cmd);
			}

			StringBuilder sb = new StringBuilder();

			sb.append(String.format("#%d ", test_case));
			for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					sb.append(map[h][w]);
					if (w == W - 1)
						sb.append("\n");
				}

			}
			System.out.print(sb);
		}
	}

	private static void doCMD(char cmd) {
		// TODO Auto-generated method stub

		if (cmd == 'S') {
			// 현재 바라보는 방향으로 대포 발사
			int bulletX = x + direction[0];
			int bulletY = y + direction[1];
			
			// 대포가 발사 되고 강철 벽을 만나거나 맵 밖으로 나가기 전까지 
			while (bulletX >= 0 && bulletY >= 0 && bulletX < W && bulletY < H) {

				//강철벽을 만나면 끝
				if (map[bulletY][bulletX] == '#')
					break;
				
				//벽을 만나면 부쉬고 다음으로 이동
				if (map[bulletY][bulletX] == '*') {
					map[bulletY][bulletX] = '.';
					break;
				}

				bulletX = bulletX + direction[0];
				bulletY = bulletY + direction[1];

			}
		} else {

			changePosition(cmd);

			int newX = x + direction[0];
			int newY = y + direction[1];

			if (newX >= 0 && newY >= 0 && newX < W && newY < H && (map[newY][newX] == '.')) {

				map[y][x] = '.';
				x = newX;
				y = newY;

			}
			map[y][x] = state;

		}

	}

	public static void changePosition(char input) {
		switch (input) {
		case 'L':
			state = '<';
			break;
		case 'R':
			state = '>';
			break;
		case 'U':
			state = '^';
			break;
		case 'D':
			state = 'v';
			break;
		}

		isPosition(state);
	}

	public static boolean isPosition(char input) {
		boolean result = true;
		switch (input) {
		case '<':
			direction[0] = -1;
			direction[1] = 0;
			break;
		case '>':
			direction[0] = 1;
			direction[1] = 0;
			break;
		case '^':
			direction[0] = 0;
			direction[1] = -1;
			break;
		case 'v':
			direction[0] = 0;
			direction[1] = 1;
			break;
		default:
			result = false;
		}

		return result;

	}
}
