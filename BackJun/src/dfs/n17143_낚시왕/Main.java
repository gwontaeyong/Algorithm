package dfs.n17143_낚시왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R;
    static int C;

    static int c_shark;
    static Shark[][] map;

    static int dc[] = {0, 0, 0, 1, -1};//. d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미한다
    static int dr[] = {0, -1, 1, 0, 0};

    static class Shark {

        int r;
        int c;
        int s;//속도
        int d;
        int z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }


    public static void main(String[] args) throws IOException {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new Shark[R + 1][C + 1];

        c_shark = Integer.parseInt(st.nextToken());


    }

    public static boolean isRange(int r, int c) {
        if (r < 1 || r > R || c < 1 || c > C)
            return false;

        return true;
    }

    public static void move(boolean map[][], Queue<Shark> queue) {



    }

    public static int change(int d) {
        if (d == 1)
            return 2;
        else if (d == 2)
            return 1;
        else if (d == 3)
            return 4;
        else
            return 3;
    }
}
