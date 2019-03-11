package d4.n7260_숫자세기;


public class Solution {
    public static void main(String[] args) {
        solve(99999, 0);
        System.out.println(max);
    }
    static int max = 0;
    static void solve(int N, int cnt) {
        //12345
        if( N < 10 )
        {
            if(max < cnt)
                max= cnt;
            return;
        }
        if( N >= 10) {
            solve((N/10)  *  (N%10), cnt+1);//1234   5
        }
        if( N >= 100 ) {
            solve((N / 100) * (N % 100) , cnt+1);//123   45
            solve((N / 100) * (N % 100/10) * (N %10) , cnt+1);//123  4  5
        }
        if( N >= 1000 ) {
            solve((N / 1000) * (N%1000),  cnt+1);//12  345
            solve((N / 1000) * (N%1000/100) * (N%100),  cnt+1);//12  3 45
            solve((N / 1000) * (N%1000/100) * (N%100/10) * (N%10),  cnt+1);//12  3 4  5
            solve((N / 1000) * (N%1000/10) * (N%10),  cnt+1);//12  34  5
        }
        if( N >= 10000 ) {
            solve((N / 10000) * (N%10000), cnt+1);//1  2345
            solve((N / 10000) * (N%10000/10) * (N%10), cnt+1);//1  234  5
            solve((N / 10000) * (N%10000/100) * (N%100), cnt+1);//1  23  45
            solve((N / 10000) * (N%10000/100) * (N%100/10) * (N%10), cnt+1);//1  23  4  5
            solve((N / 10000) * (N%10000/1000) * (N%1000), cnt+1);//1  2   345
            solve((N / 10000) * (N%10000/1000) * (N%1000/100) * (N%100), cnt+1);//1  2   3 45
            solve((N / 10000) * (N%10000/1000) * (N%1000/100) * (N%100/10) * (N%10), cnt+1);//1  2   3  4   5
            solve((N / 10000) * (N%10000/1000) * (N%1000/10) *(N%10), cnt+1);//1  2   34  5
        }
    }
}
