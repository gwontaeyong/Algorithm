package d4.n4261_빠른휴대전화키패드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {




    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub

        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int keypad[][] = new int[10][4];

        int alpa = 'a';

        for(int i = 2; i < 10; i++){

            int j = 3;

            if(i == 7 || i == 9){
                j = 4;
            }

            for(int k = 0; k < j; k++){
                keypad[i][k] = alpa;
                alpa++;
            }
        }

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            char input[] = st.nextToken().toCharArray();
            int inputNum = input.length;
            int wordNum = Integer.parseInt(st.nextToken());


            st = new StringTokenizer(br.readLine());

            int answer = 0;

            outer : for(int i = 0; i < wordNum; i++){
                char word[] = st.nextToken().toCharArray();

                if(word.length != inputNum)
                    continue;



                boolean flag = false;

                for(int z = 0; z < inputNum; z++) {
                    int numpad = input[z] - '0';
                    int j = (numpad == 7 || numpad == 9)?4:3;

                    for (int k = 0; k < j; k++) {
                        if (keypad[numpad][k] == word[z]) {
                            flag = true;
                            break;
                        }
                    }

                    if(!flag)
                        continue outer;
                }

                answer++;

            }

            System.out.println(String.format("#%d %d", t, answer));

        }


    }

}
