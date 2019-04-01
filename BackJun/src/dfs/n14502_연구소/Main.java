package dfs.n14502_연구소;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int R;
    static int C;

    static int map[][];
    static int max;

    static int dr[] = {0, 0, -1, 1};
    static int dc[] = {1, -1, 0, 0};

    static LinkedList<Point> virus;

    static int nv;
    static int nb;

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        virus = new LinkedList<>();
        nb = 0;
        max = 9999;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < C; j++) {
                int lab = Integer.parseInt(st.nextToken());

                map[i][j] = lab;

                if (lab == 2)
                    virus.add(new Point(j, i));

                if (lab == 1)
                    nb++;
            }
        }

        nv = virus.size();


        dfs(map, 0);
        int answer = R * C - nb - max;

        System.out.println(answer);

    }

    public static void dfs(int map[][], int count) {


        //System.out.println("dfs");


        if (count == 3) {
            //printMap(map);
            int tempMap[][] = map.clone();
            int newVirus = bfs(map);
            max = Math.min(max, newVirus);
            return;
        }

        for (int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++){

                if(map[r][c] == 0){
                    map[r][c] = 1;
                    dfs(map,count+1);
                    map[r][c] = 0;
                }
            }
        }

    }

    public static int bfs(int map[][]) {
        int answer = 0;

        //int tempMap[][] = Arrays.copyOf(map, map.length);
        Queue<Point> queue ;
        queue = (LinkedList) virus.clone();

        while (!queue.isEmpty()) {

            answer++;
            Point temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = temp.y + dr[i];
                int nc = temp.x + dc[i];

                if (!isRange(nr, nc) || map[nr][nc] != 0)
                    continue;

                map[nr][nc] = 2;
                ((LinkedList<Point>) queue).add(new Point(nc, nr));
            }
        }


        return answer;
    }

    public static boolean isRange(int r, int c) {

        if (r < 0 || r >= R || c < 0 || c >= C)
            return false;

        return true;
    }

    public static void printMap(int map[][]){


        for(int[] arr:map)
            System.out.println(Arrays.toString(arr));

        System.out.println();
    }


}
