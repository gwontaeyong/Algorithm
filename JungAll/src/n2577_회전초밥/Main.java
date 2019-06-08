package n2577_회전초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int d;
    static int k;
    static int c;

    static int sushi[];
    static int check[];

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("INPUT.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sushi = new int[N];
        check = new int[d + 1];

        Queue<Integer> table = new LinkedList<>();

        int max = 0;

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for (int i = 0; i < k; i++) {
            ((LinkedList<Integer>) table).add(sushi[i]);
            if (check[sushi[i]] == 0) {
                check[sushi[i]]++;
                count++;
            }
        }



        max = count;


        for (int i = 0; i < N - 1; i++) {

            table.poll();

            int index = (i + k) % N;
            int s = sushi[index];

            check[sushi[i]]--;

            if (check[sushi[i]] == 0) {
                count--;
            }


            ((LinkedList<Integer>) table).add(s);

            if (check[s] == 0) {
                count++;
            }

            check[s]++;

            if (check[c] != 0)
                max = Math.max(max, count + 1);
            else
                max = Math.max(max, count);

        }
        System.out.println(max);
    }
}
