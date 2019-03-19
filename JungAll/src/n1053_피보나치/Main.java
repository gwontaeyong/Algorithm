package n1053_피보나치;

import java.util.Scanner;

public class Main {

    static final int[][] base = {{1, 1}, {1, 0}};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {

            int n = scan.nextInt();

            if (n == -1)
                break;
            else if (n == 0) {
                System.out.println(0);
            } else {
                int result[][] = fibo(n);

                System.out.println(result[1][0]);
            }
        }

    }

    static int[][] fibo(int n) {
        if (n == 1) {
            return base;
        } else {

            int[][] res = fibo(n / 2);

            if (n % 2 == 0)
                return cal(res, res);
            else
                return cal(cal(res, res), base);
        }
    }

    static int[][] cal(int[][] a, int b[][]) {

        int arr[][] = new int[2][2];

        //arr[0][0] = arr[]
        return arr;
    }
}
