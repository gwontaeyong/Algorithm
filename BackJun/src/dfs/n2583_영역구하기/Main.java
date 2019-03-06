package dfs.n2583_영역구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean map[][];
    static boolean visited[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int M;
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int ix = x1; ix < x2; ix++) {
                for (int iy = y1; iy < y2; iy++) {
                    map[iy][ix] = true;
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int m = 0; m < M; m++){
            for(int n = 0; n < N; n++){

                count = 0;

                if(!map[m][n]){
                    dfs(n, m);
                }

                if(count != 0)
                    list.add(count);
            }
        }

        StringBuilder sb = new StringBuilder(String.format("%d\n", list.size()));

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i) + " ");
        }

        System.out.println(sb);

    }


    public static void dfs(int x, int y) {

        count++;
        map[y][x] = true;

        for (int i = 0; i < dx.length; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >=N || ny < 0 || ny >=M)
                continue;

            if(map[ny][nx])
                continue;

            dfs(nx, ny);

        }

    }


}
