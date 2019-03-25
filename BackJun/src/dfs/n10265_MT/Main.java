package dfs.n10265_MT;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int N;
    static int K;

    static int friend[];
    static boolean visited[];

    static int dp[];
    static int dp2[];

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        friend = new int[N + 1];
        dp = new int[N + 1];
        dp2 = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            friend[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= N; i++) {
            noFriend(i, 0, new boolean[N + 1]);
        }


    }

    public static void noFriend(int n, int count, boolean visited[]) {


        if (visited[n] || n == friend[n]) {
            dp[n] = count;
        } else {
            visited[n] = true;
            noFriend(friend[n], count + 1, visited);
        }

    }



}
