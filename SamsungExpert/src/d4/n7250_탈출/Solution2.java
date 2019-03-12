package d4.n7250_탈출;

import java.io.*;
import java.util.*;

public class Solution2 {

    static int N;
    static int M;
    static int K;

    static int En;
    static int Em;

    static char map[][];
    static boolean check[][][][];

    static int dm[] = {-1, 1, 0, 0};
    static int dn[] = {0, 0, -1, 1};

    static int count;

    static Queue<Fire> fq;
    static Queue<SV> svq;
    static Queue<Node> q;

    static class Node {
        int n;
        int m;
        char c;

        int k;
        int time;

        Node() {
        }

        public Node(int n, int m) {
            this.n = n;
            this.m = m;
            this.c = 'F';
        }

        public Node(int n, int m, char c, int k, int time) {
            this(n, m);
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

        System.setIn(Solution2.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            count = 987456123;
            fq = new LinkedList<>();
            svq = new LinkedList<>();
            q = new LinkedList<>();

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            check = new boolean[N][M][N][M];

            List<Node> firelist = new ArrayList<>();
            Node s = new Node();
            Node v = new Node();

            s.k = K;
            s.time = 0;
            s.c = 'S';

            v.c = 'V';

            for (int i = 0; i < N; i++) {
                String line = br.readLine();

                for (int j = 0; j < M; j++) {
                    char c = line.charAt(j);
                    map[i][j] = c;

                    if (c == 'S') {
                        s.n = i;
                        s.m = j;
                    }

                    if (c == 'V') {
                        v.n = i;
                        v.m = j;
                    }

                    if (c == 'F') {
                        firelist.add(new Node(i, j));
                    }

                    if (c == 'E') {
                        En = i;
                        Em = j;
                    }
                }
            }

            q.add(v);
            q.add(s);

            for (int i = 0; i < firelist.size(); i++) {
                q.add(firelist.get(i));
            }

            solve();


        }
    }

    static void solve() {


        while (!q.isEmpty()) {

            Node node = q.poll();

            if (node.c == 'S') {

                if (node.n == En && node.m == Em) {
                    count = node.time;
                    return;
                }

                for (int i = 0; i < 4; i++) {

                    int sn = node.n + dn[i];
                    int sm = node.m + dm[i];
                    int k = node.k;

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

                    q.add(new Node(sn, sm, 'S', k, node.time+1));
                }

            }

            if(node.c == 'V'){
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
                    if (map[vn][vm] == 'E')
                        continue;

                    if (check[sn][sm][vn][vm])
                        continue;

                    check[sn][sm][vn][vm] = false;

                    svq.add(new SV(sn, sm, vn, vm, k, sv.time + 1));
                }
            }

            if (node.c == 'F'){

            }
        }

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
