package bfs.n7569_토마토;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Data {
        int n;
        int m;
        int h;
        int time;

        public Data(int h, int n, int m, int time) {
            // TODO Auto-generated constructor stub
            this.h = h;
            this.n = n;
            this.m = m;
            this.time = time;
        }

    }

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input_2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int map[][][] = new int[H][N][M];
        boolean check[][][] = new boolean[H][N][M];

        int dx[] = {-1, 1, 0, 0, 0, 0};
        int dy[] = {0, 0, -1, 1, 0, 0};
        int dz[] = {0, 0, 0, 0, -1, 1};

        Queue<Data> queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());

                for (int m = 0; m < M; m++) {

                    int tomato = Integer.parseInt(st.nextToken());
                    map[h][n][m] = tomato;

                    if (tomato == 1) {
                        queue.add(new Data(h, n, m, 0));
                        check[h][n][m] = true;
                    }

                    if (tomato == -1) {
                        check[h][n][m] = true;
                    }


                }

            }
        }


        int time = 0;

        while (!queue.isEmpty()) {
            Data temp = queue.poll();

            if (time < temp.time)
                time = temp.time;

            for (int i = 0; i < 6; i++) {

                int nH = temp.h + dz[i];
                int nN = temp.n + dy[i];
                int nM = temp.m + dx[i];

                if (nH < 0 || nH >= H ||nN < 0 || nN >= N || nM < 0 || nM >= M)
                    continue;

                if (map[nH][nN][nM] == -1 || check[nH][nN][nM])
                    continue;

                map[nH][nN][nM] = 1;
                check[nH][nN][nM] = true;
                queue.add(new Data(nH, nN, nM, temp.time + 1));

            }
        }

        for (boolean[][] arr2 : check) {
            for (boolean[] arr : arr2) {
                for (boolean flag : arr) {
                    if (!flag) {
                        time = -1;
                        break;
                    }
                }
            }
        }

        System.out.println(time);

    }
}
