package d4.n3074_입국심사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int T, N;
    static long M;
    static long Exam_time[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            Exam_time = new long[N + 1];

            long mx = 0;
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                int time = Integer.parseInt(st.nextToken());
                Exam_time[i] = time;
                mx = mx < time ? time : mx;
            }

            long le = 0;
            long ri = mx * M;

            while (le <= ri) {
                long mid = (le + ri) / 2;

                long cnt=0;

                for (int i = 1; i <= N; i++) {
                    cnt+=mid/Exam_time[i];
                }

                if(cnt<M) {
                    le=mid+1;
                }
                else {
                    ri=mid-1;
                }
            }
            StringBuffer sb = new StringBuffer();
            sb.append("#").append(tc).append(" ").append(le);
            System.out.println(sb);
        }
    }
}