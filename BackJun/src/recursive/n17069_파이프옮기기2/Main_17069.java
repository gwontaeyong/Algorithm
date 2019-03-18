package recursive.n17069_파이프옮기기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class    Main_17069 {

	static int[][] arr;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long[][][] count = new long[N][N][3];
		
		count[0][1][0] = 1;
		

		for(int j=2;j<N;j++) {
			if(arr[0][j]==0)
				count[0][j][0] = count[0][j-1][0];
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if (arr[i][j] == 0) {
					count[i][j][0] += count[i][j-1][0] + count[i][j-1][2];
					count[i][j][1] += count[i-1][j][1] +  count[i-1][j][2];
					if(arr[i-1][j] ==0 && arr[i][j-1]==0)
						count[i][j][2] += count[i-1][j-1][0] + count[i-1][j-1][1] + count[i-1][j-1][2];
					
				} 
			}
		}

		
		System.out.println(count[N-1][N - 1][0]+count[N-1][N - 1][1]+count[N-1][N - 1][2]);
	}

}