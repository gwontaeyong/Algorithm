package 모의역량테스트.활주로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int tempmap[][];
    static int N;
    static int x;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            answer = 0;

            tempmap = new int [N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    tempmap[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int map[][] = new int[N][N];

            for(int i = 0; i < N; i++){
                map[i] = tempmap[i].clone();
            }

            //가로 평탄 검사
            outer: for(int i = 0; i < N; i++){
                int height = map[i][0];
                //가로로 이동하면서
                for(int j = 1; j < N; j++){
                    //높이가 같으면 넘어가기
                    if(map[i][j] == height)
                        continue ;
                    // 높을 경우
                    if(map[i][j] > height){

                        //높이가 1이상 차이 날 경우
                        if(map[i][j] - height != 1)
                            continue outer;

                        //뒤로 x만큼 간뒤
                        int nx = j - x;
                        //범위 초과할 경우
                        if(!isRange(nx))
                            continue outer;

                        //경사로 건설 가능 확인
                        for(int k = nx; k < j; k++){
                            if(map[i][k] != height)//중간에 높이가 변경되면 건설 불가능
                                continue outer;
                        }

                        for(int k = nx; k < j; k++){
                            map[i][k] = -1;
                        }
                        height++;
                    }else{//낮을 경우

                        //높이가 1이상 차이 날 경우
                        if( height - map[i][j]  != 1)
                            continue outer;

                        //x만큼 거리를 확보해야 한다.
                        int nx = j + x -1 ;

                        //범위 밖으로 나갈 경우
                        if(!isRange(nx))
                            continue outer;

                        //경사로 건설 가능 확인
                        for(int k = j; k <= nx; k++){
                            if(map[i][k] != height - 1)//중간에 높이가 변경되면 건설 불가능
                                continue outer;
                        }

                        for(int k = j; k <= nx; k++){
                            map[i][k] = -1;
                        }

                        height--;
                        j += x - 1;
                    }

                }


                answer++;
            }

            for(int i = 0; i < N; i++){
                map[i] = tempmap[i].clone();
            }


            //세로 평탄 검사
            outer: for(int i = 0; i < N; i++){
                int height = map[0][i];
                //세로로 이동하면서
                for(int j = 1; j < N; j++){
                    //높이가 같으면 넘어가기
                    if(map[j][i] == height)
                        continue ;
                    // 높을 경우
                    if(map[j][i] > height){

                        //높이가 1이상 차이 날 경우
                        if(map[j][i] - height != 1)
                            continue outer;

                        //뒤로 x만큼 간뒤
                        int nx = j - x;
                        //범위 초과할 경우
                        if(!isRange(nx))
                            continue outer;

                        //경사로 건설 가능 확인
                        for(int k = nx; k < j; k++){
                            if(map[k][i] != height)//중간에 높이가 변경되면 건설 불가능
                                continue outer;
                        }

                        for(int k = nx; k < j; k++){
                            map[k][i] = -1;
                        }

                        height++;
                    }else{//낮을 경우

                        //높이가 1이상 차이 날 경우
                        if( height - map[j][i]  != 1)
                            continue outer;

                        //x만큼 거리를 확보해야 한다.
                        int nx = j + x - 1;

                        //범위 밖으로 나갈 경우
                        if(!isRange(nx))
                            continue outer;

                        //경사로 건설 가능 확인
                        for(int k = j; k <= nx; k++){
                            if(map[k][i] != height - 1)//중간에 높이가 변경되면 건설 불가능
                                continue outer;
                        }
                        for(int k = j; k <= nx; k++){
                            map[k][i] = -1;
                        }
                        height--;
                        j += x - 1;
                    }

                }

                answer++;
            }

            System.out.println(String.format("#%d %d", tc, answer));

        }
    }

    public static boolean isRange(int x){
        if(x < 0 || x >= N)
            return  false;
        return true;
    }


}
