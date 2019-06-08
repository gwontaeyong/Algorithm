package dfs.n17136_색종이붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int size[] = {25, 16, 9, 4, 1};
    public static int map[][];
    public static int C;
    public static int answer;

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 10;
        answer = -1;

        for (int i = 0; i < 10; i++) {
            String arr[] = br.readLine().split(" ");
            // System.out.println(Arrays.toString(arr));
            for (int j = 0; j < 10; j++) {
                if (arr[j].equals("1"))
                    C++;
            }
        }

        System.out.println(C);
        if (C == 0)
            answer = 0;
        else
            solve(new int[5], new boolean[5], 0, 0, 0);


        System.out.println(answer);
    }

    public static void solve(int arr[], boolean visited[], int idx, int count, int sum) {


        if (sum == C) {

            System.out.println(Arrays.toString(arr));
            if (answer == -1)
                answer = count;
            else
                answer = Math.min(answer, count);
            return;
        }

        if (idx == 5 && sum < C) {
            return;
        }

        for (int i = 0; i < 5; i++) {

            if (visited[i])
                continue;

            visited[i] = true;
            for (int j = 0; j <= 5; j++) {
                int newSum = sum + size[i] * j;
                arr[idx] = j;
                if (newSum <= C)
                    solve(arr, visited, idx + 1, count + j, newSum);
                arr[idx] = 0;
            }
            visited[i] = false;
        }

    }
}
