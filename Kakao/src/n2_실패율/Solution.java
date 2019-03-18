package n2_실패율;

import java.util.*;

class Solution {

    static class Stage implements Comparable<Stage>{
        int stage;
        double pecentage;

        public Stage(int stage, double pecentage) {
            this.stage = stage;
            this.pecentage = pecentage;
        }

        @Override
        public String toString() {
            return "Stage{" +
                    "stage=" + stage +
                    ", pecentage=" + pecentage +
                    '}';
        }

        public int compareTo(Stage s){

            if(this.pecentage < s.pecentage)
                return 1;
            else if(this.pecentage == s.pecentage)
                return (this.stage < s.stage)?-1:1;
            else
                return -1;

        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = {};

        int max = stages[0];

        for (int i = 1; i < N; i++) {
            max = (max < stages[i]) ? stages[i] : max;
        }

        List<Stage> list = new ArrayList<>();


        double[] people = new double[max+1];
        double[] fail = new double[max+1];

        for (int i = 0; i < stages.length; i++) {
            int userStage = stages[i];
            fail[userStage]++;

            for (int j = 1; j <= userStage; j++) {
                people[j]++;
            }

        }

        for (int i = 1; i <= N; i++) {
            list.add(new Stage(i, fail[i] / people[i]));
        }

        Collections.sort(list);

        answer = new int[N];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).stage;
        }



        return answer;
    }

    public static void main(String[] args) {

        int[] input = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(new Solution().solution(5, input)));
    }
}