package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_11508 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        Integer arr[] = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }


        Arrays.sort(arr, Collections.reverseOrder());

        int answer = 0;

        for (int i = 1; i <= n / 3; i++) {
            answer += arr[(i * 3) - 2] + arr[(i * 3) - 3];
        }

        if (n % 3 != 0) {
            for (int i = (n - n % 3); i < n; i++) {
                answer += arr[i];
            }
        }

        System.out.println(answer);


    }
}
