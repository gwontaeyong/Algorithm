package bfs.n17071_숨바꼭질5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static boolean isRange(int n) {

        if (n < 0 || n > 500000) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int K = scan.nextInt();

        int count = 0;
        int speed = 1;

        boolean check[] = new boolean[500001];

        Queue<Integer> queue = new LinkedList<>();
        ((LinkedList<Integer>) queue).add(N);
        check[N] = true;

        outer : while (!queue.isEmpty()) {

            int size = queue.size();

            if(K > 500000) {
                count = -1;
                break;
            }

            for (int i = 0; i < size; i++) {
                int n = queue.poll();
                if(n == K){
                    break outer;
                }
                if (isRange(n - 1)) {
                    if (!check[n - 1]) {
                        check[n - 1] = true;
                        ((LinkedList<Integer>) queue).add(n - 1);
                    }
                }
                if (isRange(n + 1)) {
                    if (!check[n + 1]) {
                        check[n + 1] = true;
                        ((LinkedList<Integer>) queue).add(n + 1);
                    }
                }
                if (isRange(n * 2)) {
                    if (!check[n * 2]) {
                        check[n * 2] = true;
                        ((LinkedList<Integer>) queue).add(n * 2);
                    }
                }

            }
            count++;
            K += speed;
            speed++;
            check = new boolean[500001];
        }

        System.out.println(count);


    }
}
