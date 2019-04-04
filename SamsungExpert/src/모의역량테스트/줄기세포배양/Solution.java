package 모의역량테스트.줄기세포배양;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {


    static int N;
    static int M;
    static int K;
    static int map[][];

    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static class Node {

        int x;
        int y;
        int count;
        int init;

        Node(int x, int y, int init) {
            this.x = x;
            this.y = y;
            this.init = init;
            count = init;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N + K + 2][M + K + 2];

            Queue<Node> queue = new LinkedList<>();

            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());

                for (int m = 0; m < M; m++) {
                    int init = Integer.parseInt(st.nextToken());

                    if (init == 0)
                        continue;

                    int y = K / 2 + 1 + n;
                    int x = K / 2 + 1 + m;

                    map[y][x] = 1;

                    ((LinkedList<Node>) queue).add(new Node(x, y, init));


                }
            }


            int answer = 0;
            answer = bfs(queue);

            System.out.println(answer);


        }
    }

    public static int bfs(Queue<Node> queue) {

        // bfs를 확인하면서 세포 배양시키기
        int count = 0;

        Queue<Node> activate = new LinkedList<>();

        while (!queue.isEmpty()) {

            System.out.println(count);
            for (int arr[] : map)
                System.out.println(Arrays.toString(arr));

            System.out.println();
            if (count == K)
                break;

            for (int i = 0; i < queue.size(); i++) {
                Node temp = queue.poll();
                if (temp.count == 0) {
                   ((LinkedList<Node>) activate).add(temp);
                } else {
                    temp.count--;
                    ((LinkedList<Node>) queue).add(temp);
                }
            }

            while (!activate.isEmpty()) {
                Node temp = activate.poll();
                if (temp.count == 0) {
                    for (int j = 0; j < 4; j++) {
                        int nx = temp.x + dx[j];
                        int ny = temp.y + dy[j];
                        if (map[ny][nx] == 0) {
                            map[ny][nx] = 1;
                            ((LinkedList<Node>) queue).add(new Node(nx, ny, temp.init));
                        }
                    }
                }
            }
            count++;
        }


        return queue.size();
    }

}
