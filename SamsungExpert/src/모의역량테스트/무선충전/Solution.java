package 모의역량테스트.무선충전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {


    static int dx[] = {0, 0, 1, 0, -1};
    static int dy[] = {0, -1, 0, 1, 0};

    static int command[][];

    static Charger[] chargers;

    static class Charger implements Comparable<Charger> {
        int x;
        int y;
        int range;
        int power;
        int cpower;

        Charger(int x, int y, int range, int power) {
            this.x = x;
            this.y = y;
            this.range = range;
            this.power = power;
            cpower = power;
        }

        @Override
        public int compareTo(Charger o) {
            return this.power - o.power;
        }

        @Override
        public String toString() {
            return "Charger{" +
                    "power=" + power +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {


            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            command = new int[2][M + 1];
            chargers = new Charger[A];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int i = 1; i <= M; i++) {
                    command[j][i] = Integer.parseInt(st.nextToken());
                }
            }


            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int range = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());

                chargers[i] = new Charger(x, y, range, power);
            }

            Arrays.sort(chargers);
            //System.out.println(Arrays.toString(chargers));

            int answer = 0;

            int pointer[][] = new int[2][2];

            pointer[0][0] = 1;
            pointer[0][1] = 1;
            pointer[1][0] = 10;
            pointer[1][1] = 10;

            for (int i = 0; i <= M; i++) {

                //a, b의 x값 이동
                for (int j = 0; j < 2; j++) {
                    pointer[j][0] += dx[command[j][i]];
                }

                //a, b의 y값 이동
                for (int j = 0; j < 2; j++) {
                    pointer[j][1] += dy[command[j][i]];
                }

                boolean nearCharger[][] = new boolean[2][A];

                int numA = 0;
                int numB = 0;
                int aC = -1;
                int bC = -1;

                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < A; k++) {
                        if (canCharge(pointer[j][0], pointer[j][1], k)) {
                            nearCharger[j][k] = true;
                            if (j == 0) {
                                numA++;
                                aC = k;
                            } else {
                                numB++;
                                bC = k;
                            }
                        }
                    }
                }

                //두개의 충전소가 같을 경우
                if (aC == bC) {

                    if (aC == -1) // 두개다 충전 할 곳이 없을 경우
                        continue;


                    int powerA = chargers[aC].power;
                    int powerB = chargers[bC].power;
                    int secondA = -1;
                    int secondB = -1;

                    for (int j = 0; j < aC; j++) {
                        if (nearCharger[0][j])
                            secondA = j;
                    }

                    for (int j = 0; j < bC; j++) {
                        if (nearCharger[1][j])
                            secondB = j;
                    }

                    if(numA == 1 && numB == 1){
                        answer += powerA;
                    }else if(numA == 1 && numB > 1){
                        answer += Math.max(chargers[aC].power + chargers[secondB].power, powerA);
                    }else if(numB == 1 && numA > 1){
                        answer += Math.max(chargers[bC].power + chargers[secondA].power, powerB);
                    }else{
                        //System.out.println(secondA + " : " + secondB);
                        answer += Math.max(powerA, Math.max(powerA + chargers[secondB].power, powerA + chargers[secondA].power));
                    }


                } else {
                    //a충전
                    if (aC != -1) {
                        answer += chargers[aC].power;
                    }
                    //b충전
                    if (bC != -1) {
                        answer += chargers[bC].power;
                    }
                }


            }

            System.out.println(String.format("#%d %d", tc, answer));

        }
    }

    public static boolean canCharge(int x, int y, int idx) {

        int dis = Math.abs(x - chargers[idx].x) + Math.abs(y - chargers[idx].y);

        if (dis <= chargers[idx].range)
            return true;
        else
            return false;
    }

}
