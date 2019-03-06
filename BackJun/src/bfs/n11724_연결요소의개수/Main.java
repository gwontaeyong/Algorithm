package bfs.n11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int parent[];
	static int rank[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(Main.class.getResourceAsStream("input.txt"));//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		rank = new int[N + 1];

		boolean check[] = new boolean[N+1];
		int count = 0;

		for(int i = 0; i <= N; i++){
			makeSet(i);
		}



		for (int k = 0; k < K; k++) {

			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			union(A, B);
		}

		for(int i = 1; i <= N; i++){

			findParent(i);

			if(!check[parent[i]]){
				count++;
				check[parent[i]] = true;
			}
		}

		//System.out.println(Arrays.toString(parent));
		System.out.println(count);

		
	}

	public static void makeSet(int a){
		parent[a] = a;
		rank[a] = 0;
	}

	public static int findParent(int a){

		if(parent[a] == a)
			return a;
		else{
			parent[a] = findParent(parent[a]);
			return parent[a];
		}

	}

	public static void union(int a, int b){

		int ap = findParent(a);
		int bp = findParent(b);

		if(rank[ap] > rank[bp]){
			parent[bp] = ap;
		}else{
			parent[ap] = bp;
			if(rank[ap] == rank[bp]){
				rank[bp]++;
			}
		}
	}


}
