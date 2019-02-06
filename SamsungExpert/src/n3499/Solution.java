package n3499;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/data/input_3499"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			int size = Integer.parseInt(br.readLine());
			
			int start = 0;
			int middle = size / 2;
			
			if(size % 2 != 0)// 카드의 갯수가 홀수 일때 첫번째 카드의 수가 더 많다.
				middle++;
			

			String line[] = br.readLine().split(" ");
			String shuffle[] = new String[size];

			for(int i = 0; i < middle; i += 2) {
            	shuffle[i] = line[start++];
            	if(i+1 < size)
            		shuffle[i+1] = line[middle++];
            
            }
			
            System.out.print("#"+ (test_case + 1));
            
            for(int i = 0; i < size; i++) {
            	System.out.print(" "+shuffle[i]);
            }
            
            System.out.println();
		}
	}
}

