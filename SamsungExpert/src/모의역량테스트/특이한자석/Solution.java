package 모의역량테스트.특이한자석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int stand[];
    static int gear[][];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());

            stand = new int[6];
            gear = new int[6][8];

            //각 톱니바퀴의 자석 정보 입력 받기
            for (int i = 1; i <= 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    gear[i][j] = Integer.parseInt(st.nextToken());//1 = S, 0 = N
                }
            }

            Arrays.fill(gear[0], -1);
            Arrays.fill(gear[5], -1);

            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(st.nextToken());
                int circle = Integer.parseInt(st.nextToken());

                visited = new boolean[6];
                spin(index, circle);
            }

            int answer = 0;

            for(int i = 1; i <= 4; i++){
                int s = stand[i];
                int g = gear[i][s];
                if(g == 1)
                    answer += Math.pow(2, i - 1);
            }

            System.out.println(String.format("#%d %d", tc, answer));


        }
    }

    public static void spin(int index, int circle) {

        visited[index] = true;

        if (index <= 0 || index > 4)
            return;

        //자신의 기어 상태값 확인
        int s = stand[index];
        int srg = gear[index][(s + 2) % 8];
        int slg = gear[index][(s + 6) % 8];

        //왼쪽톱니
        int ls = stand[index - 1];
        int lrg = gear[index - 1][(ls + 2) % 8];

        //오른쪽
        int rs = stand[index + 1];
        int rlg = gear[index + 1][(rs + 6) % 8];

        if ((slg != lrg)) {
            //왼쪽 회전
            if(!visited[index - 1])
                spin(index - 1, circle * -1);
        }
        if(srg != rlg){
            //오른쪽 회전
            if(!visited[index + 1])
                spin(index + 1, circle * -1);
        }


        moveStand(index, circle);
    }

    public static void moveStand(int index, int circle){
        int s = stand[index];

        if (circle == -1) { // 왼쪽으로 회전
            s++;
        } else {//오른쪽회전
            s--;
        }

        if (s == -1)
            s = 7;
        else if (s == 8)
            s = 0;

        stand[index] = s;
    }

}
