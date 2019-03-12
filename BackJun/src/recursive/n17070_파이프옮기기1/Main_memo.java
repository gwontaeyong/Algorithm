package recursive.n17070_파이프옮기기1;

import java.util.HashMap;
import java.util.Scanner;

public class Main_memo {
	public static void main(String[] args) {
		//1. 여러분들이 했을 노가딩 버전
		//2. 1의 메모이제이션
		//3. 아영씨의 DP버전
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();
		}
		;
		System.out.println(dfs(map, 0, 1, 0));
		System.out.println("호출횟수 : " + callCnt);
	
	}
	static int ans = 0;
	static int callCnt = 0;
	//r,c는 현재 파이프의 머리위치. mode는 파이프의 방향(0:가로 . 1:세로 . 2:대각)
	static long dfs(int[][] map, int r, int c, int mode) {
		callCnt++;
		long cnt = 0;
		if( result.containsKey(r + " " + c + " " + mode)) {
			return result.get(r + " " + c + " " + mode);
		}
		if( r == map.length-1 && c == map[r].length-1 ) {
			//도착ㅋ	
			ans++;
			return 1;
		}
		//내가 현재 가로 라면, 계속 가로로 가는 경우 , 대각으로 꺾는 경우
		if(mode == 0) {
			if(  c+1 < map.length && map[r][c+1] == 0 )
				cnt += dfs(map, r, c+1, 0);
			if( r+1 < map.length && c+1 < map.length && map[r+1][c] == 0 && map[r][c+1]==0 && map[r+1][c+1] == 0)
				cnt += dfs(map, r+1, c+1, 2);
		}
		//현재 세로라면, 계속 세로로 가는 경우, 대각으로 꺾는 경우
		else if(mode == 1) {
			if( r+1 < map.length && map[r+1][c] == 0)
				cnt += dfs(map, r+1, c, 1);
			if( r+1 < map.length && c+1 < map.length && map[r+1][c] == 0 && map[r][c+1]==0 && map[r+1][c+1] == 0)
				cnt += dfs(map, r+1, c+1, 2);
		}
		//현재 대각이라면 계속 대각으로 가는 경우, 세로로 꺽는 경우, 가로로 꺽는 경우
		else {
			if(  c+1 < map.length && map[r][c+1] == 0 )
				cnt += dfs(map, r, c+1, 0);
			if( r+1 < map.length && map[r+1][c] == 0)
				cnt += dfs(map, r+1, c, 1);
			if( r+1 < map.length && c+1 < map.length && map[r+1][c] == 0 && map[r][c+1]==0 && map[r+1][c+1] == 0)
				cnt += dfs(map, r+1, c+1, 2);
		}
		result.put(r + " " + c + " " + mode, cnt);
		return cnt;
	}
	static HashMap<String, Long> result = new HashMap<>();
}
