package bfs.n11403_미로찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        boolean map[][] = new boolean[M][M];
        int result[][] = new int[M][M];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][i] = true;
            for (int j = 0; j < M; j++) {

                if (st.nextToken().equals("1"))
                    map[i][j] = true;
            }
        }


        for (int index = 0; index < M; index++) {
            result[index][index] = 1;

            for (int k = 0; k < M; k++) {

                boolean check[] = new boolean[M];

                Queue<Node> queue = new LinkedList<>();
                ((LinkedList<Node>) queue).add(new Node(index, k));



                while (!queue.isEmpty()) {

                    Node temp = queue.poll();
                    result[temp.x][temp.y] = 1;

                    check[temp.x] = true;
                    check[temp.y] = true;

                    if (map[temp.x][temp.y] ) {

                        for(int i = 0; i < M; i++) {
                            if (map[temp.y][i] && !check[i]) {
                                ((LinkedList<Node>) queue).add(new Node(temp.y, i));
                            }
                        }

                    }

                }


            }
        }

        for(int[] arr:result)
            System.out.println(Arrays.toString(arr));
    }
}
