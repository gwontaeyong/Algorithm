package bfs.n2636_치즈;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int dm[] = { -1, 1, 0, 0 };
	static int dn[] = { 0, 0, -1, 1 };

	static int N;
	static int M;

	static Queue<Pointer> cheezeQueue;

	static int time;
	static int count;

	static int map[][];

	static class Pointer{
		int n;
		int m;

		Pointer(int n, int m){
			this.n = n;
			this.m = m;
		}
	}

	public static void main(String[] args) throws IOException {

		System.setIn(Main.class.getResourceAsStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		cheezeQueue = new LinkedList<>();

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());

			for(int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		while(true){
			// 0, 0 연결된 공기는 외부 공기이다.
			// 외부공기와 연결된 치즈를 삭제할 치즈에 추가한다.
			boolean visited[][] = new boolean[N][M];


			Queue<Pointer> airQueue = new LinkedList<>();
			((LinkedList<Pointer>) airQueue).push(new Pointer(0, 0));

			while(!airQueue.isEmpty()){
				Pointer temp = airQueue.poll();
				visited[temp.n][temp.m] = true;

				for (int i = 0; i < 4; i++) {
					int nN = temp.n + dn[i];
					int nM = temp.m + dm[i];

					if(!isRange(nN, nM) || visited[nN][nM])
						continue;

					visited[nN][nM] = true;

					if(map[nN][nM] == 1) {
						cheezeQueue.add(new Pointer(nN, nM));
					}else{
						airQueue.add(new Pointer(nN, nM));
					}

				}
			}

			if(cheezeQueue.size() == 0)
				break;

			count = cheezeQueue.size();

			while(!cheezeQueue.isEmpty()){
				Pointer temp = cheezeQueue.poll();
				map[temp.n][temp.m] = 0;
			}

			time++;
			// 삭제가 예상된 치즈를 실제로 지운다.?
		}

		System.out.println(String.format("%d\n%d", time, count));

	}

	public static boolean isRange(int n, int m){

		if( n < 0 || n >= N || m < 0 || m >= M)
			return false;

		return true;
	}
}
