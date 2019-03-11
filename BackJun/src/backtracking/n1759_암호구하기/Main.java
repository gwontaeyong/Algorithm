package backtracking.n1759_암호구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static int N;

    static char arr[];
    static char moeum[] = {'a', 'e', 'i', 'o', 'u'};

    static boolean moCheck[];

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new char[N];
        moCheck = new boolean[26];

        //모음 체커 만들기
        for (int i = 0; i < moeum.length; i++)
            moCheck['z' - moeum[i]] = true;


        st = new StringTokenizer(br.readLine());

        //전체 값 받기
        for (int i = 0; i < N; i++)
            arr[i] = st.nextToken().charAt(0);

        Arrays.sort(arr);// 정렬

        dfs(new boolean[N], 0, 0);
    }

    public static void dfs(boolean visited[], int idx, int count) {
        if (count == K) {
            StringBuilder sb = new StringBuilder();

            int mo = 0;
            int ja = 0;


            for (int i = 0; i < N; i++) {

                if (visited[i]) {

                    if (moCheck['z' - arr[i]])
                        mo++;
                    else
                        ja++;
                    sb.append(String.format("%c ", arr[i]));
                }

            }
            if (mo >= 1 || ja >= 2)
                System.out.println(sb);
            return;
        }

        for (int i = idx; i < N; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            dfs(visited, i + 1, count + 1);
            visited[i] = false;
        }
    }

    /*
    acis
acit
aciw
acst
acsw
actw
aist
aisw
aitw
astw
cist
cisw
citw
istw

     */
}
