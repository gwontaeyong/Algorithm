package recursive.n17070_파이프옮기기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean map[][];

    static int S = 0;
    static int L = 1;
    static int R = 2;

    static int C = 0;
    static int H = 1;
    static int V = 2;

    // state, direction
    static int mx[][] = {{1, 1, 0}, {1, 1, 1}, {0, 1, -1}};
    static int my[][] = {{1, 0, 1}, {0, -1, 1}, {1, 1, 1}};

    static int count;

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //변수 초기화
        count = 0;
        N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];

        // 장애물이 있으면 true
        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().equals("1");
            }
        }

        
        solve(1, 0, H);

        System.out.println(count);

    }

    public static void solve(int x, int y, int s) {


        if (x == N - 1 && y == N - 1) {
            //if (s != C)
            count++;

            return;
        }

        //i = 직 좌 우
        for (int i = 0; i < 3; i++) {


            if ((s == V && i == R) || (s == H && i == L))
                continue;

            int nx = x + mx[s][i];
            int ny = y + my[s][i];


            if (!isRange(nx, ny))
                continue;

            if (!canMove(nx, ny, s, i))
                continue;

            int ns = s;

            if (s == C) {
                if (i != S)
                    ns = (i == L) ? H : V;

            } else {
                if (i != S)
                    ns = C;
            }

            solve(nx, ny, ns);


        }


    }

    // out of range = false;
    // in of range = true;
    static boolean isRange(int x, int y) {

        if (x < 0 || x >= N || y < 0 || y >= N)
            return false;

        return true;

    }

    static boolean canMove(int x, int y, int s, int d) {

//        printS(x, y, s, d);
        if (d == S) {
            if (s == C)
                return !(map[y][x] || map[y - 1][x] || map[y][x - 1]);
        } else {
            if (s != C)
                return !(map[y][x] || map[y - 1][x] || map[y][x - 1]);
        }

        return !map[y][x];
    }

    static void printS(int x, int y, int s, int d) {

        char ss = (s == 0) ? 'C' : (s == 1) ? 'H' : 'V';
        char dd = (d == 0) ? 'S' : (d == 1) ? 'L' : 'R';

        System.out.println(String.format("X = %d, Y = %d, %c %c", x, y, ss, dd));
    }

}
/*


8+3-2-4+8-7-2-4-0+8=8
8+3-2-4+8-7-2-4+0+8=8
8+3+2+4-8-7+2-4-0+8=8
8+3+2+4-8-7+2-4+0+8=8
8+3+2-4+8-7+2+4-0-8=8
8+3+2-4+8-7+2+4+0-8=8
8-3+2+4-8+7+2+4-0-8=8
8-3+2+4-8+7+2+4+0-8=8
8-3+2-4+8+7+2-4-0-8=8
8-3+2-4+8+7+2-4+0-8=8


 */