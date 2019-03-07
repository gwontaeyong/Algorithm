package backtracking.n1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int dn[] = {1, -1, N};

        int time = 0;

        Queue<Integer[]> q = new LinkedList<>();
        Integer[] temp = {N, time};

        ((LinkedList<Integer[]>) q).add(temp);


        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp[0] == M) {
                time = temp[1];
                break;
            }

            for (int i = 0; i < 3; i++) {
                int newN = temp[0] + dn[i];
                Integer[] temp2 = {newN, temp[1] + 1};

                ((LinkedList<Integer[]>) q).add(temp2);
            }

        }

        System.out.println(time);
    }
}
