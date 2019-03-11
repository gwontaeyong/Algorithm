package bfs.n13460_구슬찾기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {

    static char map[][];
    static boolean hall[][];

    static int answer;

    static int N;
    static int M;


    static int dm[] = {-1, 1, 0, 0};
    static int dn[] = {0, 0, -1, 1};
    static boolean visited[][][][];

    static Queue<Position> queue;

    static class Position {

        int bn;
        int bm;
        int rn;
        int rm;
        int count;

        public Position(){
            this.count = 0;
        }

        public Position(int newBN, int newBM, int newRN, int newRM, int count) {
            this.bn = newBN;
            this.bm = newBM;
            this.rn = newRN;
            this.rm = newRM;
            this.count = count;
        }

        public String toString(){
            return bn +" " + bm + " : " + rn + " " + rm;
        }
    }


    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = -1;

        map = new char[N][M];
        hall = new boolean[N][M];

        visited = new boolean[N][M][N][M];
        Position p = new Position();
        queue = new LinkedList<>();

        for (int n = 0; n < N; n++) {
            String line = br.readLine();

            for (int m = 0; m < M; m++) {

                char c = line.charAt(m);

                if (c == '#') {
                    map[n][m] = c;
                    continue;
                }

                map[n][m] = '.';

                if (c == '.') {
                    continue;
                }

                if (c == 'R') {
                    p.rn = n;
                    p.rm = m;
                } else if (c == 'B') {
                    p.bn = n;
                    p.bm = m;
                } else if (c  == 'O')
                    hall[n][m] = true;
            }

        }

        visited[p.bn][p.bm][p.rn][p.rm] = true;
        queue.add(p);

        bfs();
        System.out.println(answer);

    }

    public static void bfs() {
        while (!queue.isEmpty()) {

            Position temp = queue.poll();


            int bn = temp.bn;
            int bm = temp.bm;

            int rn = temp.rn;
            int rm = temp.rm;

            if (temp.count > 10) {
                answer = -1;
                break;
            }

            if (hall[rn][rm]) {
                answer = temp.count;
                break;
            }

            temp.count++;

            outer: for (int i = 0; i < 4; i++) {


                int newBN = bn;
                int newBM = bm;

                int newRN = rn;
                int newRM = rm;


                while (true) {

                    if (map[newBN + dn[i]][newBM + dm[i]] == '#') {
                        break;
                    }

                    newBN += dn[i];
                    newBM += dm[i];

                    if(hall[newBN][newBM]){
                       continue outer;
                    }

                }

                while (true) {

                    if (map[newRN + dn[i]][newRM + dm[i]] == '#')
                        break;

                    newRN += dn[i];
                    newRM += dm[i];

                    if(hall[newRN][newRM]){
                        break;
                    }

                }

                if(newBM == newRM && newBN == newRN){

                    if (Math.abs(rn - newRN) + Math.abs(rm - newRM) > Math.abs(bn - newBN) + Math.abs(bm - newBM))
                    {
                        newRN -= dn[i];
                        newRM -= dm[i];
                    }
                    else
                    {
                        newBN -= dn[i];
                        newBM -= dm[i];
                    }

                }

                if(visited[newBN][newBM][newRN][newRM])
                    continue;


                visited[newBN][newBM][newRN][newRM] = true;
                temp = new Position(newBN, newBM, newRN, newRM, temp.count);
                queue.add(temp);
            }
        }

    }


}

