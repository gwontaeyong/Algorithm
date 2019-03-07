package backtracking.n6603_로또;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String arr[];

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {

            String line = br.readLine();

            if (line.equals("0"))
                break;

            arr = line.split(" ");

            // System.out.println(Arrays.toString(arr));
            dfs(new boolean[arr.length - 1], 0, 0);
            System.out.println();

        }


    }

    public static void dfs(boolean vistied[], int idx, int count) {


        if (count == 6) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < vistied.length; i++) {
                if (vistied[i]) {
                    sb.append(String.format("%s ", arr[i + 1]));
                }
            }
            System.out.println(sb);
            return;
        }

        for (int i = idx; i < vistied.length; i++) {
            if (vistied[i])
                continue;

            vistied[i] = true;
            dfs(vistied, i, count + 1);
            vistied[i] = false;
        }
    }
}
