package backtracking.n9663_NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    static boolean map[][];
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];

        dfs(0);
        System.out.println(count);

    }

    public static void dfs(int depth){

        if(depth == N){

            count++;
            return;
        }

        for(int i = 0; i < N; i++){
            if(isPromise(depth, i)){
                map[depth][i] = true;
                dfs(depth+1);
                map[depth][i] = false;
            }
        }
    }

    public static boolean isPromise(int y, int x){


        //y 축 체크
        for(int iy = 0; iy < y; iy++){
            if(map[iy][x])
                return false;
        }

        //대각선 체크
        int left = x;
        int right = x;

        for (int j = y; j >= 0; j--) {
            if (left >= 0 && map[j][left]) {
                return false;
            }
            if (right < N && map[j][right]) {
                return false;
            }
            left--;
            right++;
        }

        return true;
    }
}
