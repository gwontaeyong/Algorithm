package bfs.n11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(Main.class.getResourceAsStream("input.txt"));//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int arr[] = new int[N + 1];

		for(int i = 0; i <= N; i++){
			makeSet(arr, i);
		}

		System.out.println(Arrays.toString(arr));

		for (int k = 0; k < K; k++) {

			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

		}

		
	}

	public static void makeSet(int arr[], int a){
		arr[a] = a;
	}

	public static int findParent(int arr[], int a){

		if(arr[a] == a)
			return a;

		return findParent(arr, arr[a]);
	}


}
