package 모의역량테스트.n1953_탈주범검거;


import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static boolean pip[][] = {
            {false, false, false, false},
            {true, true, true, true},
            {false, false, true, true},
            {true, true, false, false},
            {false, true, true, false},
            {false, true, false, true},
            {true, false, false, true},
            {true, false, true, false}
    };

    public static int L = 0;
    public static int R = 1;
    public static int U = 2;
    public static int D = 3;

    public static int[] dm = {1, -1, 0, 0};
    public static int[] dn = {0, 0, -1, 1};

    public static int N;
    public static int M;

    static int map[][];
    static boolean visited[][];

    static int answer;

    public static boolean isConnect(int p1, int d1, int p2, int d2) {

        if (pip[p1][d1] && pip[p2][d2])
            return true;
        else
            return false;
    }

    public static int move(int p, int d) {

        for (int i = 0; i < 4; i++) {
            if (i == d)
                continue;

            if (pip[p][i])
                return i;
        }

        return -1;
    }

    public static class Node {
        int n;
        int m;
        int d;

        Node(int m, int n, int d) {
            this.n = n;
            this.m = m;
            this.d = d;
        }

        @Override
        public String toString() {
            return "n=" + n +
                    ", m=" + m +
                    ", d=" + d;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        System.out.println("T" + T);
        for (int t = 1; t <= T; t++) {
            answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            System.out.println(N + " " + M);
            int dn = Integer.parseInt(st.nextToken());
            int dm = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[n][m] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(dm, dn, k);

        }


    }

    public static void bfs(int x, int y, int k) {

        Queue<Node> queue = new LinkedList<>();
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            if (pip[map[y][x]][i]) {
                int nm = x + dm[i];
                int nn = y + dn[i];
                queue.add(new Node(nm, nn, i));
            }
        }



        System.out.println(queue);


    }

    public static char printD(int d) {

        char c = ' ';

        switch (d) {
            case 0:
                c = 'L';
                break;
            case 1:
                c = 'R';
                break;
            case 2:
                c = 'U';
                break;
            case 3:
                c = 'D';
                break;
        }
        return c;
    }
}

