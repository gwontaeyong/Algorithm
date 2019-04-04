package d4.n5658_보물상자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws IOException {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());


        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            char arr[] = br.readLine().toCharArray();

            Set<String> set = new HashSet<>();


            int len = N / 4;

            for (int i = 0; i < len; i++) {

                int count = 0;
                String str = "";

                for (int idx = i; idx < i + N; idx++) {
                    count++;
                    str += arr[idx % N];

                    if (count == len) {
                        count = 0;
                        set.add(str);
                        str = "";
                    }
                }

            }

            ArrayList<Long> list = new ArrayList<>();
            List<String> strList = new ArrayList<>();

            strList.addAll(set);

            for (int i = 0; i < strList.size(); i++) {
                String str = strList.get(i);
                list.add(Long.parseLong(str, 16));
            }

            Collections.sort(list, Collections.reverseOrder());

            System.out.println(String.format("#%d %d", t, list.get(K - 1)));
        }
    }


}