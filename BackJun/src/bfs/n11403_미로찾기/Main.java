package bfs.n11403_미로찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        boolean map[][] = new boolean[M][M];
        int result[][] = new int[M][M];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {

                if (st.nextToken().equals("1"))
                    map[i][j] = true;
            }
        }


        //0 부터 M-1번까지 탐색 시작
        for (int i = 0; i < M; i++) {
            //i 번째 노드에 연결되어 있는 모든 노드들을 Queue에 추가
            Queue<Integer> queue = new LinkedList<>();
            boolean check[] = new boolean[M];


            for(int j = 0; j < M; j++){
                if (map[i][j]) {
                    queue.add(j);
                }
            }

            while(!queue.isEmpty()){

                int temp = queue.poll();
                result[i][temp] = 1;

                check[temp] = true;

                for(int j = 0; j < M; j++){
                    if (map[temp][j] && !check[j]) {
                        queue.add(j);
                    }
                }

            }

        }

        StringBuilder sb = new StringBuilder();

        for(int[] arr:result){
            for(int a:arr){
                sb.append(String.format("%d ", a));
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}
