package dp.n1003_피보나치;

import java.util.Scanner;

public class Main {

    static class Node {
        int one;
        int zero;

        Node(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }


    public static void main(String[] args) {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        for (int t = 0; t < T; t++) {
            int n = scan.nextInt();
            Node dp[] = new Node[n+1];



            for(int i = 0; i <= n; i++){

                if(i == 0)
                    dp[0] = new Node(1, 0);

                if(i == 1)
                    dp[1] = new Node(0, 1);

                if(i >= 2) {
                    int zero = dp[i - 2].zero + dp[i - 1].zero;
                    int one = dp[i - 2].one + dp[i - 1].one;
                    dp[i] = new Node(zero, one);
                }
            }

            System.out.println(dp[n].zero + " " + dp[n].one);
        }

    }

}
