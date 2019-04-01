package d4.n5656_벽돌깨기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int w;
    static int h;
    static int answer;

    static int dw[] = {-1, 1, 0, 0};
    static int dh[] = {0, 0, -1, 1};

    static class Block{
        int x;
        int y;
        int size;

        Block(int x, int y, int size){
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }


    static boolean Range(int x, int y) {
        if (x < 0 || y < 0 || x >= w || y >= h)
            return false;

        return true;
    }

    public static int bfs(int map[][], int w) {

        int c_num = 0;

        for (int i = 0; i < h; i++) {

            if (map[i][w] != 0) {
                Queue<Block> queue = new LinkedList<>();
                ((LinkedList<Block>) queue).add(new Block(w, i, map[i][w] - 1));
                map[i][w] = 0;

                while(!queue.isEmpty()){
                    Block b = queue.poll();
                    c_num++;

                    for (int j = 0; j < 4; j++) {

                        int nw = b.x + dw[j];
                        int nh = b.y + dh[j];
                        int size = b.size;

                        while(Range(nw, nh) && size != 0){
                            if (map[nh][nw] != 0) {
                                ((LinkedList<Block>) queue).add(new Block(nw, nh, map[nh][nw] - 1));
                                map[nh][nw] = 0;
                            }

                            nw += dw[j];
                            nh += dh[j];
                            size--;
                        }
                    }
                }

                break;
            }
        }
        return c_num;
    }

    public static void down(int map[][]){

        for(int i = 0; i < w; i++){

            Queue<Integer> temp = new LinkedList<>();

            for(int j = h - 1; j >=0; j--){
                if(map[j][i] != 0){
                    ((LinkedList<Integer>) temp).add(map[j][i]);
                }
                map[j][i] = 0;
            }

            for(int j = h - 1; j >=0; j--){
                if(temp.isEmpty())
                    break;

                map[j][i] = temp.poll();
            }
        }
    }


    public static int countMap(int map[][]){
        int count = 0;

        for(int[] arr:map){
            for(int i : arr){
                if(i != 0)
                    count++;
            }
        }

        return count;

    }
    public static void dfs(int map[][], int n, int b_num) {

        if (n == 0) {
            answer = Math.min(answer, countMap(map));
            return;
        }

        for (int i = 0; i < w; i++) {

            int temp[][] = new int[h][w];

            for (int j = 0; j < h; j++) {
                temp[j] = map[j].clone();
            }

            //삭제하고
            int c_num = bfs(temp, i);
            //아래로 밀기
            down(temp);
            //dfs 다시 돌리기
            dfs(temp, n - 1, b_num + c_num);

        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());


        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            answer = 987456321;

            int map[][] = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(map, n, 0);
           // print(map);
            //down(map);

            //System.out.println();
            //print(map);
            System.out.println(answer);

        }
    }

    public static void print(int map[][]){
        for(int arr[] :map)
            System.out.println(Arrays.toString(arr));
    }
}