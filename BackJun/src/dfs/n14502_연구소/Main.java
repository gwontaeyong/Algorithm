package dfs.n14502_연구소;


import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;


public class Main {

    static int N;
    static int M;

    static int empty_count;
    static int virus_count;

    static List<Point> virus;
    static int map[][];
    static boolean visited[][];

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static int answer;

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = Integer.MAX_VALUE;

        map = new int[N][N];
        visited = new boolean[N][N];

        virus = new ArrayList<>();
        //데이터 받기
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                int data = Integer.parseInt(st.nextToken());

                //만약 빈칸이라면 나중에 바이러스를 채워야 한다.
                if (data != 1) {
                    empty_count++;
                    //그 곳에 바이러스를 놓을 수 있는 경우 리스트에 좌표를 저장한다.
                    if (data == 2) {
                        virus.add(new Point(x, y));
                    }
                } else
                    visited[y][x] = true;

                map[y][x] = data;
            }
        }

        virus_count = virus.size();


        getCom(new int[M], 0, 0, virus_count, M);

        if (answer == Integer.MAX_VALUE)
            answer = -1;
        System.out.println(answer);
    }

    public static void bfs(int v_index[], boolean check[][]) {

        Queue<Point> queue = new LinkedList<>();
        int count = 0;
        int time = 0;

        for (int i = 0; i < M; i++) {
            Point temp = virus.get(v_index[i]);
            check[temp.y][temp.x] = true;
            count++;
            queue.add(temp);
        }


        while (!queue.isEmpty()) {
            int size = queue.size();
            if (time > answer || count == empty_count)
                break;

            time++;
            for (int i = 0; i < size; i++) {
                Point temp = queue.poll();


                for (int j = 0; j < 4; j++) {
                    int nx = temp.x + dx[j];
                    int ny = temp.y + dy[j];


                    //범위 밖으로 나가거나
                    //벽을 만나거나
                    //이전에 탐색했던 장소
                    if (!isRange(nx, ny) || map[ny][nx] == 1 || check[ny][nx])
                        continue;

                    count++;
                    check[ny][nx] = true;
                    ((LinkedList<Point>) queue).add(new Point(nx, ny));
                }
            }
        }

        
        if (count == empty_count) {
            answer = Math.min(time, answer);
        }


    }

    public static boolean isRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N)
            return false;
        return true;
    }

    public static void getCom(int result[], int idx, int count, int n, int r) {


        if (count == r) {
            boolean temp[][] = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                temp[i] = visited[i].clone();
            }

            bfs(result, temp);
            return;
        }

        for (int i = idx; i < n; i++) {
            result[count] = i;
            getCom(result, i + 1, count + 1, n, r);
        }
    }

    public static void getPerm(int result[], boolean visited[], int count, int n, int r) {

        if (count == r) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            result[count] = i;
            getPerm(result, visited, count + 1, n, r);
            visited[i] = false;
        }
    }


}
