package n1206;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("src/data/input_1206.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// max width = 1000
		// max height = 255;

		for (int T = 0; T < 10; T++) {
			int count = 0;
			int arr[] = new int[Integer.parseInt(br.readLine())];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 2; i < arr.length - 2; i++) {
				int leftMax = (arr[i - 1] > arr[i - 2]) ? arr[i - 1] : arr[i - 2];
				int rightMax = (arr[i + 1] > arr[i + 2]) ? arr[i + 1] : arr[i + 2];
				int building = arr[i];

				if (leftMax >= building || rightMax >= building)
					continue;

				int mostMax = (leftMax > rightMax) ? leftMax : rightMax;

				if (mostMax >= building)
					continue;

				count += building - mostMax;
			}

			String answer = "#";
			StringBuilder sb = new StringBuilder();
			sb.append("#");
			sb.append(T+1);
			sb.append(" ");
			sb.append(count);
			System.out.println(sb);
			
		}

	}

}
