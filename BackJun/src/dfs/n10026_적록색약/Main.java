package dfs.n10026_적록색약;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static char map[][];

    static int rgbC;
    static int rbC;

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static boolean isRange(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >=N)
            return false;

        return true;
    }
    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        rgbC = 0;
        rbC = 0;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        boolean rgbV[][] = new boolean[N][N];
        boolean rbV[][] = new boolean[N][N];

        Queue<Point> queue = new LinkedList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){

                char c = map[i][j];

                // 적록색약 아닌사람이 봤을때 탐색
                if(!rgbV[i][j]) {
                    rgbC++;
                    ((LinkedList<Point>) queue).add(new Point(j, i));
                    rgbV[i][j] = true;
                }

                while(!queue.isEmpty()){
                    Point temp = queue.poll();

                    int x = temp.x;
                    int y = temp.y;

                    for(int k = 0; k < 4; k++){

                        int nX = x + dx[k];
                        int nY = y + dy[k];

                        if(!isRange(nX, nY) || rgbV[nY][nX] || c != map[nY][nX])
                            continue;

                        rgbV[nY][nX] = true;
                        ((LinkedList<Point>) queue).add(new Point(nX, nY));
                    }
                }



                // 적록색 약인 사람이 탐색

                if(!rbV[i][j]) {
                    rbC++;
                    ((LinkedList<Point>) queue).add(new Point(j, i));
                    rbV[i][j] = true;
                }

                while(!queue.isEmpty()){
                    Point temp = queue.poll();

                    int x = temp.x;
                    int y = temp.y;

                    for(int k = 0; k < 4; k++){

                        int nX = x + dx[k];
                        int nY = y + dy[k];

                        if(!isRange(nX, nY) || rbV[nY][nX])
                            continue;

                        if((c == 'R' || c == 'G') && map[nY][nX] == 'B')
                            continue;

                        if(c == 'B' && map[nY][nX] != 'B')
                            continue;

                        rbV[nY][nX] = true;
                        ((LinkedList<Point>) queue).add(new Point(nX, nY));
                    }
                }

            }
        }

        System.out.println(rgbC + " " + rbC);
    }




}
