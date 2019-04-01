package n2283_RGB마을;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("INPUT.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int house[][] = new int[N][3];
        int rgb[] = new int[3];

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rgb[0] = house[0][0];
        rgb[1] = house[0][1];
        rgb[2] = house[0][2];

        int temp[] = new int[3];


        for (int i = 1; i < N; i++) {

            temp[0] = house[i][0] + Math.min(rgb[1], rgb[2]);
            temp[1] = house[i][1] + Math.min(rgb[0], rgb[2]);
            temp[2] = house[i][2] + Math.min(rgb[1], rgb[0]);


            rgb[0] = temp[0];
            rgb[1] = temp[1];
            rgb[2] = temp[2];

            //rgb = temp;

        }


        int answer = Math.min(rgb[0], Math.min(rgb[1], rgb[2]));

        System.out.println(answer);


    }
}
