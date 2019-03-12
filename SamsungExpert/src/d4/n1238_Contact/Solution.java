package d4.n1238_Contact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static boolean map[][];
    static boolean check[];
    static int N;
    static int S;
    static int answer;

    static class Node {
        int index;
        int time;

        Node(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {


        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            map = new boolean[N + 1][N + 1];
            check = new boolean[N + 1];

            st = new StringTokenizer(br.readLine());


            for (int i = 0; i < N / 2; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = true;
            }
            bfs();


            System.out.println(String.format("#%d %d", tc, answer));

        }
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(S, 0));
        int max = S;
        int depth = 0;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if(depth != temp.time){
                max = temp.index;
                depth = temp.time;
            }else{
                max = (max > temp.index)?max:temp.index;
            }

            for (int i = 1; i <= N; i++) {
                if (map[temp.index][i] && !check[i]) {
                    check[i] = true;
                    ((LinkedList<Node>) queue).add(new Node(i, temp.time + 1));
                }
            }
        }

        answer = max;

    }

}
