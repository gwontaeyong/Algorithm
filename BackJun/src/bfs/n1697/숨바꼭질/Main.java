package bfs.n1697.숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Move {
        int n;
        int time;

        Move(int n, int time) {
            this.n = n;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(Solution.class.getResourceAsStream("input_2.txt"));//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Move> queue = new LinkedList();
        Move temp = new Move(N, 0);
        queue.add(temp);

        boolean check[] = new boolean[100000+1];

        while (!queue.isEmpty()) {

            temp = queue.poll();


            if (temp.n == K) {
                break;
            }

            int dn[] = {-1, 1, temp.n};

            for (int i = 0; i < 3; i++) {
                int newN = temp.n + dn[i];

                if (newN < 0 || newN > 100000)
                    continue;

                if(check[newN])
                    continue;

                check[newN] = true;
                ((LinkedList<Move>) queue).add(new Move(newN, temp.time
                        + 1));
            }

        }

        System.out.println(temp.time);
    }

}
