package d5.n1789_범준이의제주도여행계획;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int N; //여행 일수
    static int M; //노드 갯수
    static int MAX = 9 * 60;
    static int ap;

    static int time;

    static int map[][];
    static Node[] nodes;

    static class Node {
        char type;
        int value;
        int time;

        Node(char type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "type=" + type +
                    ", value=" + value +
                    ", time=" + time +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            time = 0;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            nodes = new Node[N];

            // 소요시간 맵 받기
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = i + 1; j < N; j++) {
                    int time = Integer.parseInt(st.nextToken());

                    map[i][j] = time;
                    map[j][i] = time;
                }
            }

            //노드 정보 받기
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                char type = st.nextToken().charAt(0);

                Node temp = new Node(type);

                if (type == 'P') {
                    int time = Integer.parseInt(st.nextToken());
                    int value = Integer.parseInt(st.nextToken());
                    temp.time = time;
                    temp.value = value;
                }

                if(type == 'A')
                    ap = i;

                nodes[i] = temp;
            }



        }
    }
}
