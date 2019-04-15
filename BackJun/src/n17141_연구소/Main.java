package n17141_연구소;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static char map[][];
	static boolean check[][];

	static ArrayList<Point> list;
	static int count;
	static int min;
	static int answer;

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static int che;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setIn(Main.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][N];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);

				// 채워야할 갯수 세기
				if (map[i][j] != '1')
					count++;

				if (map[i][j] == '2')
					list.add(new Point(j, i));
			}
		}

		min = 2 * N;
		answer = -1;

		int c = list.size();

		combination(new int[M], new boolean[c], c, 0, M, 0);
		System.out.println(answer);

	}

	public static void printMap() {

		for (char arr[] : map)
			System.out.println(Arrays.toString(arr));
	}

	public static void combination(int arr[], boolean result[], int n, int idx, int r, int count) {

		if (count == r) {
			bfs(arr);
			return;
		}

		for (int i = idx; i < n; i++) {
			if (result[i])
				continue;
			result[i] = true;
			arr[count] = i;
			combination(arr, result, n, i, r, count + 1);
			result[i] = false;
		}
	}

	public static boolean isRange(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		return true;
	}

	public static void bfs(int result[]) {

		int size = result.length;
		Queue<Point> queue = new LinkedList<>();
		check = new boolean[N][N];

		for (int i = 0; i < M; i++) {
			queue.add(list.get(result[i]));
		}
		
	
	}

}
