package bfs.n1012_유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input_2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int dm[] = {-1, 1, 0, 0};
        int dn[] = {0, 0, -1, 1};

        for (int tc = 1; tc <= T; tc++) {


            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            boolean map[][] = new boolean[N][M];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = true;
            }


            int count = 0;

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {

                    if (map[n][m]) {
                        count++;

                        Integer temp[] = {n, m};
                        Queue<Integer[]> queue = new LinkedList<>();

                        queue.add(temp);

                        while (!queue.isEmpty()) {
                            temp = queue.poll();

                            for (int i = 0; i < dn.length; i++) {
                                int newM = temp[1] + dm[i];
                                int newN = temp[0] + dn[i];

                                if (newM < 0 || newM >= M || newN < 0 || newN >= N)
                                    continue;

                                if(!map[newN][newM])
                                    continue;

                                Integer temp2[] = {newN, newM};
                                map[newN][newM] = false;
                                queue.add(temp2);


                            }
                        }

                    }
                }
            }

            System.out.println(count);


        }
    }
}
