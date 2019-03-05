package d3.n1493;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public  static class Data {
		int data;
		int x;
		int y;

		public Data(int data, int x, int y) {
			this.data = data;
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("src/data/input_1493.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int q = 45000;
		
		Data map[] = new Data[q + 1];
		map[1] = new Data(1, 1, 1);
		
		int yIndex = 1;
		
		for(int i = 2; i < q + 1; i++) {
			if(map[i - 1].y == 1) {
				yIndex++;
				map[i] = new Data(i, 1, yIndex);
			}else {
				map[i] = new Data(i, map[i - 1].x + 1, map[i - 1].y - 1);
			}
		}
		
		System.out.println(map[45000].x + " " + map[45000].y);
		for (int test_case = 0; test_case < T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Data first = map[Integer.parseInt(st.nextToken())];
			Data second = map[Integer.parseInt(st.nextToken())];
			
			int x = first.x + second.x;
			int y = first.y + second.y;
			
			for(int i = 1; i < q + 1; i++) {
				if(map[i].x == x && map[i].y == y) {
					System.out.println("#" + (test_case + 1) + " " + map[i].data);
					break;
				}
			}
			

		}


	}

}
