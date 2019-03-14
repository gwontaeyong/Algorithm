package n2_실패율;

import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int max = stages[0];

        for (int i = 1; i < N; i++) {
            max = (max < answer[i]) ? answer[i] : max;
        }


        int[] percent = new int[max + 1];
        int[] people = new int[max + 1];
        int[] pass = new int[max + 1];

        for (int i = 0; i < N; i++) {

            for (int j = 1; j < stages[i]; j++){
                pass[i]++;
                people[i]++;
            }

            people[max]++;
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] input = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(new Solution().solution(input.length, input)));
    }
}