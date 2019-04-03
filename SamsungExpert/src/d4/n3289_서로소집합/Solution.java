package d4.n3289_서로소집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {


    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int parent[] = new int[N + 1];

            StringBuilder answer = new StringBuilder();

            for (int i = 1; i <= N; i++) {
                makeSet(parent, i);
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int c = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (c == 0) {

                    union(parent, a, b);

                } else {
                    int ap = findSet(parent, a);
                    int bp = findSet(parent, b);
                    if (ap == bp)
                        answer.append(1);
                    else
                        answer.append(0);
                }
            }

            //printArr(parent);
            System.out.println(String.format("#%d %s", tc, answer));
        }

    }

    public static void printArr(int arr[]) {
        System.out.println(Arrays.toString(arr));
    }

    // 1.make_set -> 초기 설정
    public static void makeSet(int parent[], int x) {
        parent[x] = x;
    }

    // 2.union -> 트리끼리
    public static void union(int parent[], int x, int y) {
        int px = findSet(parent, x);
        int py = findSet(parent, y);

        if (px > py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }

    // 3.findset

    public static int findSet(int parent[], int x) {
        if (parent[x] == x) {
            return x;
        } else {
            parent[x] = findSet(parent, parent[x]);
            return parent[x];
        }
    }

}