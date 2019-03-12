package d4.n7250_탈출;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    static int N;
    static int M;
    static int K;

    static int En;
    static int Em;

    static char map[][];
    static boolean check[][][][];
    static boolean firecheck[][];

    static int dm[] = {-1, 1, 0, 0};
    static int dn[] = {0, 0, -1, 1};

    static int count;

    static Queue<Fire> fq;
    static Queue<SV> svq;

    static class Node {
        int n;
        int m;
        char c;

        int k;
        int time;

        Node() {
        }

        public Node(int n, int m) {

        }

        public Node(int n, int m, char c, int k, int time) {
            this.n = n;
            this.m = m;
            this.c = c;
            this.k = k;
            this.time = time;
        }
    }

    static class Fire {
        int n;
        int m;
        int time;

        public Fire(int n, int m, int time) {
            this.n = n;
            this.m = m;
            this.time = time;

        }
    }

    static class SV {
        int sn;
        int sm;
        int vn;
        int vm;

        int k;
        int time;

        SV() {

        }

        SV(int sn, int sm, int vn, int vm, int k, int time) {
            this.sn = sn;
            this.sm = sm;
            this.vn = vn;
            this.vm = vm;
            this.k = k;

            this.time = time;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub

        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            count = 987456123;
            fq = new LinkedList<>();
            svq = new LinkedList<>();

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            check = new boolean[N][M][N][M];
            firecheck = new boolean[N][M];

            SV sv = new SV();

            for (int i = 0; i < N; i++) {
                String line = br.readLine();

                for (int j = 0; j < M; j++) {
                    char c = line.charAt(j);
                    map[i][j] = c;

                    if (c == 'S') {
                        sv.sn = i;
                        sv.sm = j;
                    }

                    if (c == 'V') {
                        sv.vn = i;
                        sv.vm = j;
                    }

                    if (c == 'F') {
                        firecheck[i][j] = true;
                        fq.add(new Fire(i, j, 0));
                    }

                    if (c == 'E') {
                        En = i;
                        Em = j;
                    }
                }
            }

            svq.add(sv);
            solve();
            System.out.println(count);

        }
    }

    static void solve() {

        int time = 0;
        int ft = 0;
        boolean flag = false;

        while (!svq.isEmpty()) {

            SV sv = svq.poll();

            //불 지를 타이밍을 확인
            if(time != sv.time){
                time = sv.time;
                flag = true;
            }

            //불을 한번 쫙 지르기
            if (flag) {
                while (!fq.isEmpty()) {

                    Fire f = fq.peek();

                    if(ft != f.time){
                        ft = f.time;
                        break;
                    }

                    for(int i = 0; i < 4; i++){
                        int fn = f.n + dn[i];
                        int fm = f.m + dm[i];

                        if (!isRange(fn, fm))
                            continue;

                        //불이나 통과 못하는 벽을 만날 경우
                        if (map[fn][fm] == 'W'|| map[fn][fm] == 'X')
                            continue;

                        if(firecheck[fn][fm])
                            continue;

                        firecheck[fn][fm] =true;
                        fq.add(new Fire(fn, fm, f.time + 1));

                    }
                    fq.poll();
                }
            }

            //탈출 성공
            if(sv.sn == En && sv.sm== Em){
                count = sv.time;
                return;
            }
            //엔트맨이랑 악당 움직인다.
            for (int i = 0; i < 4; i++) {

                int sn = sv.sn + dn[i];
                int sm = sv.sm + dm[i];
                int k = sv.k;

                //범위에 벗어날 경우
                if (!isRange(sn, sm))
                    continue;

                //불이나 통과 못하는 벽을 만날 경우
                if (map[sn][sm] == 'F' || map[sn][sm] == 'X')
                    continue;


                //벽을 마주 쳤을때
                if (map[sn][sm] == 'W') {

                    // 축소 가능
                    if (k == 0)
                        continue;
                        //불가능
                    else
                        k--;
                }

                //일반 길 지나가면 다시 k 를 초기화
                if (map[sn][sm] == 'A')
                    k = K;


                //악당 이동
                for (int j = 0; j < 4; j++) {

                    int vn = sv.vn + dn[i];
                    int vm = sv.vm + dm[i];

                    if (!isRange(vn, vm))
                        continue;
                    //악당은 벽을 통과 못한다.
                    if (map[vn][vm] == 'W' || map[vn][vm] == 'X')
                        continue;

                    //악당이 탈출하면 그 케이스는 셀 수 없음
                    if (map[vn][vm] == 'E') {
                        count = -1;
                        return;
                    }

                    if (check[sn][sm][vn][vm])
                        continue;

                    check[sn][sm][vn][vm] = false;
                    svq.add(new SV(sn, sm, vn, vm, k, sv.time + 1));
                }
            }

        }

        count = -1;

    }

    static boolean isRange(int n, int m) {
        if (n < 0 || n >= N || m < 0 || m >= N)
            return false;
        return true;
    }

    static boolean isWall(int n, int m) {

        return map[n][m] == 'W';
    }


}
