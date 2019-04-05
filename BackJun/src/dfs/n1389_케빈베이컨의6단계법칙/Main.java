package dfs.n1389_케빈베이컨의6단계법칙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    static boolean map[][];
    static boolean visited[];

    static int backen[][];
    static int min;

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        backen = new int[N + 1][N + 1];
        min = 987654321;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = true;
            map[b][a] = true;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j)
                    backen[i][j] = 987654321;
            }
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                visited = new boolean[N + 1];
                if (i != j)
                    dfs(i, j, 0, i);
            }
        }


        int answer = 1;
        int sum = 0;

        for(int i = 1; i <= N; i++){
            sum += backen[1][i];
        }

        for(int i = 2; i <= N; i++){
            int temp = 0;

            for(int j = 1; j <= N; j++){
                temp += backen[i][j];
            }

            if(sum > temp){
                answer = i;
                sum = temp;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int start, int target, int count, int index) {


        visited[index] = true;

        if (index == target) {

            backen[start][target] = Math.min(count, backen[start][target]);
            return;
        }

        if (count >= min) {
            return;
        }


        for (int i = 1; i <= N; i++) {

            if (i == index || visited[i] || !map[index][i])
                continue;

            visited[i] = true;
            dfs(start, target, count + 1, i);
            visited[i] = false;
        }

    }


}
