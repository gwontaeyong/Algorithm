package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2455_지능형기차 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int answer = 0;
		int max = 0;

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int leave = Integer.parseInt(st.nextToken());
			int income = Integer.parseInt(st.nextToken());

			//System.out.println(leave + " " + income);
			answer -= leave;
			answer += income;

			max = Math.max(max, answer);
		}

		System.out.println(max);
	}
}
