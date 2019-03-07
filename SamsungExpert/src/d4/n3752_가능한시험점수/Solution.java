package d4.n3752_가능한시험점수;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int arr[];

    static boolean check[];

    static int count;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub

        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            count = 0;

            N = Integer.parseInt(br.readLine());
            arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int sum = 0;

            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());

                arr[i] = num;
                sum += num;

            }

            check = new boolean[100001];
            check[0] = true;

            for(int i = 0; i < N; i++){
                for (int j = 0; j <= sum; j++) {

                    if(check[j]){
                        check[j + arr[i]] = true;
                    }

                }
            }

            for (int j = 0; j <= sum; j++) {

                if(check[j]){
                    count++;
                }

            }

            System.out.println(String.format("#%d %d", tc, count));

        }
    }

    public static void dfs(boolean visited[], int idx){

        if(idx == N){

            //System.out.println(Arrays.toString(visited));
            int sum = 0;

            for(int i = 0; i < N; i++){
                if(visited[i])
                    sum += arr[i];
            }

            if(!check[sum]){
                check[sum] = true;
                count++;
            }
            return;
        }


        visited[idx] = true;
        dfs(visited, idx+1);
        visited[idx] = false;
        dfs(visited, idx+1);

    }


}
