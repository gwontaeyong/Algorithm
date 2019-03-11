package d4.n1808_지희의고장난시계;
import java.util.Scanner;

public class Solution {
    static boolean[] pad = new boolean[10];
    static int N;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            for(int i = 0; i < 10; i++)
                pad[i] = sc.nextInt() == 1;
            N = sc.nextInt();
            ans = Integer.MAX_VALUE;
            solve(N);
            System.out.println(ans == Integer.MAX_VALUE ? -1 : ans+1);
        }
    }
    static int solve(int n) {
        //n이 주어진 패드로 누를 수 있다면, 해당 길이를 리턴
        if( canPress(String.valueOf(n))) {
            //처음 호출 자체가 맞는 경우
            if( n == N )
                ans = String.valueOf(n).length();

            //약수를 쪼갠숫자가 누를 수 있는 경우
            return String.valueOf(n).length();
        }
        //누를 수 없다면 약수에 대해서 누를 수 있는지 재귀호출
        else {
            int ret = -1;
            for(int i = n/2; i > 1; i--) {
                //i를 2부터 n/2까지 검사하면서, i가 n을 나눌 수 있으면서 누를 수 있는 숫자라면.
                if( n % i == 0 && canPress( String.valueOf(i) )) {
                    int front = String.valueOf(i).length() + 1; //i를 누르는 횟수 + 곱하기버튼 한번 더
                    int rear = solve(n/i);
                    if( rear != -1) {
                        int len = front+rear;
                        if( len < ans && n == N)
                            ans = len;
                        ret = len;
                    }
                }
            }
            return ret;
        }
    }

    static boolean canPress(String num) {
        for(int i = 0; i < num.length(); i++) {
            if( !pad[ num.charAt(i) - '0'] )
                return false;
        }

        return true;
    }
}
