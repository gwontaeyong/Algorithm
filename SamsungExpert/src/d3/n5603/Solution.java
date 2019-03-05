package d3.n5603;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {

		int LASTDAY[] = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int start_date = 4;

		System.setIn(new FileInputStream("src/data/input_5603.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int sum = 0;
			int answer = 0;
			
			int arr[] = new int[n];

			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(br.readLine());
				sum += arr[j];
			}
			
			int avr = sum / n;
			
			for (int j = 0; j < n; j++) {
				if(arr[j] < avr)
					answer += avr - arr[j];
			}
			
			System.out.println("#" + (i+1) + " " + answer);
			
		}
	}
}
