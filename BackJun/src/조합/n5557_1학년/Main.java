package 조합.n5557_1학년;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int count;
    static int arr[];
    static int N;


    public static void main(String[] args) throws IOException {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //System.out.println(Arrays.toString(arr));
        combination(0, 0);
        System.out.println(count);
    }

    public static void combination(int sum, int idx) {

        if (idx == N - 1) {

            if (sum == arr[N - 1]) {
                count++;
            }

            return;
        }


        if (sum < 0 || sum > 20)
            return;




        combination(sum + arr[idx], idx + 1);
        combination(sum - arr[idx], idx + 1);


    }
}

/*


8+3-2-4+8-7-2-4-0+8=8
8+3-2-4+8-7-2-4+0+8=8
8+3+2+4-8-7+2-4-0+8=8
8+3+2+4-8-7+2-4+0+8=8
8+3+2-4+8-7+2+4-0-8=8
8+3+2-4+8-7+2+4+0-8=8
8-3+2+4-8+7+2+4-0-8=8
8-3+2+4-8+7+2+4+0-8=8
8-3+2-4+8+7+2-4-0-8=8
8-3+2-4+8+7+2-4+0-8=8


 */