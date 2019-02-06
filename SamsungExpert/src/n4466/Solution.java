package n4466;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/data/input_4466.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String line = br.readLine();

			StringTokenizer st = new StringTokenizer(line, " ");

			int size = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			int scores[] = new int[size];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < size; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
			}

			boubleSort(scores);
			int max_sum = 0;
			
			for(int i= 0; i<num; i++) {
				max_sum += scores[i];
			}
			
			System.out.println("#"+test_case+" "+max_sum);
		}

	}

	public static void boubleSort(int arr[]) {

		for (int j = 1; j <= arr.length; j++) {
			for (int i = 0; i < arr.length - j; i++) {
				if (arr[i] < arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}
}
