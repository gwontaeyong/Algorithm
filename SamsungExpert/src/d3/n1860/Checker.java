package d3.n1860;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Checker {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader frA = new BufferedReader(
				new InputStreamReader(new FileInputStream("/Users/gwontaeyong/Desktop/Answer")));
		BufferedReader frB = new BufferedReader(
				new InputStreamReader(new FileInputStream("/Users/gwontaeyong/Desktop/Solution")));

		String strA = frA.readLine();
		String strB = frB.readLine();
		int count = 0;
		
		while (strA != null) {
			
			if(!strA.equals(strB)) {
				count++;
				System.out.println("A : "+ strA);
				System.out.println("S : "+ strB);
				System.out.println();
			}
			strA = frA.readLine();
			strB = frB.readLine();
		}
		
		System.out.println(count);
		
	}

}
