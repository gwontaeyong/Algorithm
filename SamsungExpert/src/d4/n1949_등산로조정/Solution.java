package d4.n1949_등산로조정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static double map[][];
    static int n;
    static int k;

    static int dx [] = {1, -1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static class Rode {
        int x;
        int y;
        int count;
        boolean isCut;

        Rode(int x, int y, int count, boolean isCut) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.isCut = isCut;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

        }
    }

    public static void dfs(int map[][], int x, int y, int count, boolean isCut) {


        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(map[ny][nx] <= map[y][x]){// 다음에 갈 등산로가 현재보다 작을 경우

                if(isCut){
                    // 최대값 확인
                    continue;
                }else{
                    //현재 등산로의 높이를 k가지로 변경
                }
            }



        }


    }

}