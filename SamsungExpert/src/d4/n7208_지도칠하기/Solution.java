package d4.n7208_지도칠하기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static boolean[][] map;
    static int color[];
    static int change;
    static int sums[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub

        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            change = 0;
            N = Integer.parseInt(br.readLine());

            map = new boolean[N+1][N+1];
            color = new int[N+1];
            sums = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i < N+1; i++) {
                color[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < N+1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < N+1; j++) {
                    map[i][j] = st.nextToken().equals("1");
                    if(map[i][j] == true)
                        sums[i] ++;
                }
            }

            int index[] = sums;

            Arrays.sort(index);

            boolean check[] = new boolean[N+1];

            for(int i = 1; i < N +1; i++){
                int j;

                for(j = 1; j < N + 1; j++){
                    if(index[i] == sums[j]){
                        break;
                    }
                }

                solve(j);
            }


            System.out.println(String.format("#%d %d",tc,change));
        }
    }

    static void solve(int n) {


        boolean cc[] = new boolean[5];// 자기 주의에 노드들이 가지고 잇는 색깔
        cc[color[n]] = true;
        boolean flag = false; // 자기색깔이랑 인접노드랑 색갈이 같은 경우가 있으면 true


        //인접노드를 탐색하면 색깔 중복 확인
        for (int i = 1; i < N+1; i++) {

            if (map[n][i]) {
                cc[color[i]] = true;
                if(color[n] == color[i])
                    flag =true;
            }
        }

        if (flag) {
            for (int i = 1; i < 5; i++) { //color 인덱스
                if (!cc[i]) { // 색깔이 중복 되지 않은 경우
                    color[n] = i;
                    break;
                }
            }
            change++;
        }

    }


}
