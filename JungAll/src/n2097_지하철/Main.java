package n2097_지하철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int map[][];

    static int count;

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("INPUT.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //printMap();

        boolean visited[] = new boolean[N + 1];
        int distance[] = new int[N + 1];
        int path[] = new int[N + 1];

        //배열 초기화

        for (int i = 1; i <= N; i++)
            distance[i] = 999;

        distance[1] = 0;
        int current = 1;

        for (int j = 1; j <= N; j++) {

            int min = 999;

            for (int i = 1; i <= N; i++) {
                if (min > distance[i] && !visited[i]) {
                    current = i;
                    min = distance[i];
                }
            }

            visited[current] = true;

            for (int i = 1; i <= N; i++) {
                if (map[current][i] == 999)
                    continue;

                if (distance[i] > map[current][i] + distance[current]) {

                    distance[i] = Math.min(distance[i], map[current][i] + distance[current]);
                    path[i] = current;
                }

            }

        }

        int j = M;

        StringBuilder sb = new StringBuilder();

        sb.append(M);

        while (j != 1) {
            sb.insert(0, path[j] + " ");
            j = path[j];
        }

        sb.insert(0, distance[M] + "\n");

        System.out.println(sb);
    }

    public static void printMap() {
        for (int[] arr : map)
            System.out.println(Arrays.toString(arr));

        System.out.println();
    }

}
