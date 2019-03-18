package d4.n1824_혁진이의프로그램검증;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int L = 0;
    static int R = 1;
    static int U = 2;
    static int D = 3;

    static int dm[] = {-1, 1, 0, 0};
    static int dn[] = {0, 0, -1, 1};

    static boolean result;
    static boolean check[][][][];
    static char map[][];

    static int N;
    static int M;

    static class Node {
        int d;
        int n;
        int m;
        int M;

        public Node(int M, int d, int n, int m) {
            this.d = d;
            this.n = n;
            this.m = m;
            this.M = M;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "d=" + d +
                    ", n=" + n +
                    ", m=" + m +
                    ", M=" + M +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {

        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            result = false;

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            check = new boolean[16][4][N][M];

            for (int i = 0; i < N; i++) {

                String line = br.readLine();

                for (int j = 0; j < M; j++) {
                    map[i][j] = line.charAt(j);
                }

            }
            bfs();
            String answer = (result)?"YES":"NO";
            System.out.println(String.format("#%d %s", t, answer));

        }
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        check[0][R][0][0] = true;

        ((LinkedList<Node>) queue).add(new Node(0, R, 0, 0));

        while (!queue.isEmpty()) {

            Node temp = queue.poll();

            int d = temp.d;
            int n = temp.n;
            int m = temp.m;
            int M = temp.M;

            char c = map[n][m];

            //명령어를 확인 해서 종료 명령어면 종료
            if (c == '@') {
                result = true;
                break;
            }

            boolean flag = false;

            // 물음 표일 경우 4방 탐색 시작
            if (c == '?') {
                flag = true;
            }

            for (int i = 0; i < 4; i++) {
                if (flag || i == d) {
                    // 물음표가 아니면 해당 방향에 대해서만 탐색 시작


                    int[] arr = doCMD(c, d, M); // 명령어 실행
                    // 이동 방향 변경, 메모리 값 변경
                    int nd = arr[0];
                    int nM = arr[1];

                    if(flag)
                        nd = i;
                    //다음에 가게 될 좌표 구하기
                    int nmArr[] = getPosition(nd, n, m);

                    int nn = nmArr[0];
                    int nm = nmArr[1];

                    if (check[nM][nd][nn][nm])
                        continue;

                    check[nM][nd][nn][nm] = true;
                    ((LinkedList<Node>) queue).add(new Node(nM, nd, nn, nm));

                }
            }


        }
    }

    static int[] getPosition(int d, int n, int m) {
        int arr[] = new int[2];

        int nn = n + dn[d];
        int nm = m + dm[d];

        if (nn < 0 || nn >= N || nm < 0 || nm >= M) {
            if (d == R) {
                nn = n;
                nm = 0;
            } else if (d == L) {
                nn = n;
                nm = M - 1;
            } else if (d == U) {
                nn = N - 1;
                nm = m;
            } else if (d == D) {
                nn = 0;
                nm = m;
            }
        }

        arr[0] = nn;
        arr[1] = nm;

        return arr;
    }

    static int[] doCMD(char c, int direct, int memory) {

        int arr[] = new int[2];
        int nd = direct;

        if (c == '<') {
            nd = L;
        } else if (c == '>') {
            nd = R;
        } else if (c == '^') {
            nd = U;
        } else if (c == 'v') {
            nd = D;
        } else if (c == '_') {
            if (memory == 0) {
                nd = R;
            } else {
                nd = L;
            }
        } else if (c == '|') {
            if (memory == 0) {
                nd = D;
            } else {
                nd = U;
            }
        } else if (c == '+') {
            memory++;

            if (memory > 15)
                memory = 0;

        } else if (c == '-') {
            memory--;

            if (memory < 0)
                memory = 15;

        } else if (c >= '0' && c <= '9') {
            memory = c - '0';
        }

        arr[0] = nd;
        arr[1] = memory;

        return arr;
    }
}
