package dp.n1149_RGB거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int rgb[] = new int[3];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int temp[] = new int[3];

            temp[0] = Integer.parseInt(st.nextToken()) + Math.min(rgb[1], rgb[2]);
            temp[1] = Integer.parseInt(st.nextToken()) + Math.min(rgb[0], rgb[2]);
            temp[2] = Integer.parseInt(st.nextToken()) + Math.min(rgb[1], rgb[0]);

            for (int j = 0; j < 3; j++)
                rgb[j] = temp[j];

        }

        int answer = Math.min(rgb[0], Math.min(rgb[1], rgb[2]));

        System.out.println(answer);


    }
}
