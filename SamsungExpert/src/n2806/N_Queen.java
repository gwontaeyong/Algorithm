package n2806;

import java.util.Scanner;

public class N_Queen {
	public static void main(String[] args) {
		// 사용자로부터 n을 입력받아서 n * n 체스판에서 n개의 퀸이 서로 위협받지 않는
		// 배치의 경우의 수를 출력하시오.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];

		backtrack(map, 0, N);
		System.out.println(cnt);
	}

	static int cnt = 0;

	static void backtrack(int[][] map, int line, int N) {
		cnt++;
		if (line == N) {
			// 마지막 줄 까지 잘 놨습니다.
			// 현재 상황이 N-Queen들이 서로 위협인지 검사해서, 문제 없으면 cnt++
			return;
		}
		// 0번 라인 안에서 어딘가에 퀸을 놓고 다음 라인 호출
		for (int i = 0; i < N; i++) {
			boolean isOk = true;
			int left = i;
			int right = i;
			for (int j = line; j >= 0; j--) {
				if (map[j][i] == 1)
					isOk = false;
				if (left >= 0 && map[j][left] == 1) {
					isOk = false;
				}
				if (right < N && map[j][right] == 1) {
					isOk = false;
				}
				left--;
				right++;
			}
			// 현재 놓을라고 하는 좌표가 line,1 인데 그 자리에 퀸을 놔도 기존에 자리잡은 퀸들을 위협하지 않는지 검사.
			if (isOk) {
				map[line][i] = 1;
				backtrack(map, line + 1, N);
				map[line][i] = 0;
			}
		}

	}

}
