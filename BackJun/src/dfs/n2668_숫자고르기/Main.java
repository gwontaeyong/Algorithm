package dfs.n2668_숫자고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int N;

    static int[][] map;
    static boolean[][] range;

    static boolean answer[];

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());

        map = new int[2][N + 1];
        range = new boolean[N + 1][N + 1];
        answer = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            map[0][i] = i;
            map[1][i] = Integer.parseInt(br.readLine());

            range[i][map[1][i]] = true;
        }


        for (int i = 1; i <= N; i++) {
            if (answer[i])
                continue;

            dfs(new boolean[N + 1], i, i);
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            if(answer[i])
                list.add(i);
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        sb.append(list.size() + "\n");

        for(int i : list){
            sb.append(i + "\n");
        }

        System.out.println(sb);
    }

    public static void dfs(boolean check[], int start, int next) {

        if (check[next]) {
            if (start == next) {
                for (int i = 1; i <= N; i++) {
                    if (check[i])
                        answer[i] = true;
                }
            }
            return;
        }


        check[next] = true;
        int nextIdx = map[1][next];

        if (!answer[nextIdx])
            dfs(check, start, nextIdx);

    }

}
